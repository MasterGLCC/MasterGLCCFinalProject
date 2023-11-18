package net.codejava;

import java.security.Principal;
import java.util.Optional;
import java.util.Random;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	 	private final UserRepository userRepository;
	   private final BCryptPasswordEncoder passwordEncoder;

	    @Autowired
	    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    public User findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

	    public boolean checkPassword(User user, String password) {
	        return passwordEncoder.matches(password, user.getPassword());
	    }
	    
	    public String updatePasswordWithRandom(String cin) {
	        User user = userRepository.findByCin(cin);
	        if (user != null) {
	            String randomPassword = generateRandomPassword();
	            String encodedPassword = passwordEncoder.encode(randomPassword);
	            user.setPassword(encodedPassword);
	            userRepository.save(user);

	            return randomPassword; // Return the generated password
	        }
	        return null; // Or throw an exception if user is not found
	    }
	    private String generateRandomPassword() {
	        // Implement your logic for random password generation
	        // Example: generating a 10-character alphanumeric string
	        int length = 8;
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        Random random = new Random();
	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            sb.append(characters.charAt(random.nextInt(characters.length())));
	        }
	        return sb.toString();
	    }
	    public User getUserIdFromPrincipal(Principal principal) {
	        if (principal instanceof User) {
	            //return ((User) principal).getId();
	        	return (User) principal;
	        }
	        return null; // or handle this case appropriately
	    }
	    
	    
	   
	    

	

	  
}
