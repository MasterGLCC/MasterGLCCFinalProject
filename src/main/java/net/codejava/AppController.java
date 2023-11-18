package net.codejava;

import java.awt.print.Pageable;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	 @Autowired
	 private ForumRepository forumRepo;
	 
	 @Autowired
	 private MessageRepository messageRepo;
	 
	
	
	 private final UserService userService;

	 @Autowired
	 public AppController(UserService userService) {
	        this.userService = userService;
	 }
	
	       
	
	@GetMapping("/")
	public String viewHomePage(Model model, @RequestParam(defaultValue = "0") int page,@RequestParam(required = false) String error) {
	    
		 if (error != null) {
	            // Add an attribute to show login error
	            model.addAttribute("error", true);
	        }
		PageRequest pageable =  PageRequest.of(page, 3); // 5 items per page
		
//        List<Forum> listforum = forumRepo.findAll();
//		model.addAttribute("listforum", listforum);
		
		Page<Forum> itemPage = forumRepo.findAll(pageable);
	    model.addAttribute("listforum", itemPage.getContent());
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", itemPage.getTotalPages());
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model,@RequestParam(required = false) String error) {
		
		if (error != null) {
            // Add an attribute to show login error
            model.addAttribute("error", true);
        }
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
        	
            return "redirect:/dashboard";
        }
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	@GetMapping("/login")
	public String showLoginForm(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            // Add an attribute to show login error
            model.addAttribute("loginError", true);
        }
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
	            // User is already authenticated, redirect to dashboard
	            return "redirect:/dashboard";
	        }

	        return "login"; // Return login view
		
	}
//	@PostMapping("/login")
//    public String login(User loginUser) {
//        User user = userService.findByEmail(loginUser.getEmail());
//        if (user != null && userService.checkPassword(user, loginUser.getPassword())) {    	
//        	return "redirect:/dashboard";
//        	//return "dashboard";
//        } else {
//        	return "redirect:/login?error=true";
//        }
//    }
    
	@PostMapping("/process_register")
	public String processRegister(User user) {
		try {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
		} catch (Exception e) {
			//model.addAttribute("error", e);
			return "redirect:/register?error=true";
		}
	}
	
//	@GetMapping("/sucess")
//	public String test()
//	{
//		return "register_success";
//	}
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	@GetMapping("/dashboard")
	 public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName(); // Get logged in username
        model.addAttribute("userName", userName);
        List<Forum> listforum = forumRepo.findAll();
		model.addAttribute("listforum", listforum);
        return "home";
    }
	@GetMapping("/ourForums")
	 public String ourForum(Model model,@RequestParam(required = false) String error) {
			
			if (error != null) {
	            // Add an attribute to show login error
	            model.addAttribute("error", true);
	        }
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       String userName = auth.getName(); // Get logged in username
       model.addAttribute("userName", userName);
     
       User currentUser = userRepo.findByUsername(userName); // Assuming you have this method to find user by username

       List<Forum> listforum = forumRepo.findByUser(currentUser);
		model.addAttribute("listforum", listforum);
       return "ourForums";
   }
	@GetMapping("/createForum")
	 public String showcreateForumPage(Model model) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       String userName = auth.getName(); // Get logged in username
       
       model.addAttribute("userName", userName);
      
       model.addAttribute("forum", new Forum());
       
       return "createForum";
   }
	
	public boolean isUserPostOwner(Long id, String userName) {
	    Forum post = forumRepo.findByForumId(id);
	    return post.getUser().getUsername().equals(userName);
	}
	@GetMapping("/editForum/{id}")
	 public String showeditForumPage(Model model,@PathVariable Long id) {
		 try {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       String userName = auth.getName(); // Get logged in username
       model.addAttribute("userName", userName);
       Forum forumx =forumRepo.findByForumId(id);
       if (isUserPostOwner(forumx.getForumId(), userName)) {
          // return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not Authorized to edit this post");
    	  
       model.addAttribute("forum", forumx);
       return "editForum";
    	   
       }
       }catch (Exception e) {
		   return "redirect:/ourForums?error=true";
	}
       return "redirect:/ourForums";
   }
	@PostMapping("/sendcreateForum")
	 public String createForum(@ModelAttribute Forum forum,BindingResult result) {
		    if (result.hasErrors()) {
		    	 return "redirect:/createForum";
		    }
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String userName = auth.getName(); 
	    User iduser = userRepo.findByUsername(userName);
	    forum.setUser(iduser);
	    try {
			forumRepo.save(forum);
	    }catch (Exception e) {
	    	return "redirect:/createForum?error=true";
		}
	        return "redirect:/createForum";
		//return "register_success";
		
	}
	public Long urlID=null;
	@GetMapping("/showForumSpec/{id}")
	public String showForum(Model model,@PathVariable Long id) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String userName = auth.getName(); // Get logged in username
	        model.addAttribute("userName", userName);
	     //   User xc=userRepo.findByUsername(userName);
		Forum forum =forumRepo.findByForumId(id);
		
		model.addAttribute("message",new Message());
		model.addAttribute("forum",forum);
		List<Message> ms=messageRepo.findByForum(forum);
		urlID=id;
		model.addAttribute("messageslist",ms);
		
//		List<Message> listUF=messageRepo.findByUser(xc);
//		model.addAttribute("messagesFU",listUF);
		return "showForum";
		
	}
	
	@PostMapping("/sendeditForum")
	 public String editForum(@ModelAttribute Forum forum,BindingResult result) {
		    if (result.hasErrors()) {
		    	 return "redirect:/ourForums";
		    }
		    Forum x=forumRepo.findByForumId(forum.getForumId());
		    x.setForumname(forum.getForumname());
		    x.setContexte(forum.getContexte());
			forumRepo.save(x);
	        return "redirect:/ourForums";
		
	}
	@GetMapping("/deleteForumSpec/{id}")
	public String deleteForumSpec(@PathVariable Long id) 
	{	//messageRepo.deleteById(id);
		forumRepo.deleteById(id);
		return "redirect:/ourForums";
	}
	@PostMapping("/sendMessage")
	 public String message(Message message) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String userName = auth.getName(); 
	    User iduser = userRepo.findByUsername(userName);
	    Forum idForum=forumRepo.findByForumId(urlID);
	    message.setUser(iduser);
	    message.setForum(idForum);
		messageRepo.save(message);
		return "redirect:/showForumSpec/"+urlID;
		
	}
	@GetMapping("/profil")
	public String profil(Model model,@RequestParam(required = false) String error) {
		
		if (error != null) {
            // Add an attribute to show login error
            model.addAttribute("error", true);
        }
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String userName = auth.getName(); // Get logged in username
	        model.addAttribute("userName", userName);
	        
	        User user =userRepo.findByUsername(userName);
			model.addAttribute("user",user);
			
		return "profilpage";
		
	}
	
	@PostMapping("/saveUser")
	public String modifprofil(Model model,@ModelAttribute User user) {
		try {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String userName = auth.getName(); // Get logged in username
	        User userx =userRepo.findByUsername(userName);
	        //userx.setUsername(user.getUsername());
	        userx.setAdresse(user.getAdresse());
	        userx.setCin(user.getCin());
	        userx.setEmail(user.getEmail());
	        userx.setFirstName(user.getFirstName());
	        userx.setLastName(user.getLastName());
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			userx.setPassword(encodedPassword);
	      
	       userRepo.save(userx);
  		  return "redirect:/profil"; 
		} catch (Exception e) {
			//model.addAttribute("error", e);
			return "redirect:/profil?error=true";
		}
		
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/forgetpassword")
	public String forgetpassword(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            // Add an attribute to show login error
            model.addAttribute("loginError", true);
        }
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
	            // User is already authenticated, redirect to dashboard
	            return "redirect:/dashboard";
	        }
		return "forgetPassword";
	}
	@PostMapping("/forgetpass")
	public String resetforgetpassword(@RequestParam String cin, Model model) {
        String newPassword = userService.updatePasswordWithRandom(cin);

        if (newPassword != null) {
            model.addAttribute("newPassword", newPassword);
            return "forgetPassword";
            //return "redirect:/forgetpassword"; // Name of the Thymeleaf template to display the password
        } else {
            // Handle the case where the user is not found or show an error message
            return "redirect:/forgetpassword?error=userNotFound";
        }
    
	}
	@GetMapping("/forgetpass")
	public String fogpss()
	{
		 return "forgetPassword";
	}
	
	@GetMapping("/createASK")
	public String createAsk()
	{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            // User is already authenticated, redirect to dashboard
            return "redirect:/createForum";
        }
        return "redirect:/?error=true";
	}
	@GetMapping("/deleteMessage/{id}")
	public String deleteMessage(@PathVariable Long id)
	{
		messageRepo.deleteById(id);
		return "redirect:/showForumSpec/"+urlID;
	}
}
