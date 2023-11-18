package net.codejava;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ForumRepository extends JpaRepository<Forum, Long> {
	 List<Forum> findByUser(User user);
	 public Forum findByForumId(Long id);
	//Forum findForu(Long forumId);

}
