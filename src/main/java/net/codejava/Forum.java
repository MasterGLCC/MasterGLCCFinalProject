package net.codejava;

import javax.persistence.*;
import java.util.List;

@Entity
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forumId;
    
    
    private String forumname;
    
   
	private String contexte;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> listeMessages;

    @OneToOne
    @JoinColumn(name = "personne_id")
    private User user;

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public List<Message> getListeMessages() {
		return listeMessages;
	}

	public void setListeMessages(List<Message> listeMessages) {
		this.listeMessages = listeMessages;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user=user;
	}

	public String getForumname() {
		return forumname;
	}

	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
    
    
    
}
