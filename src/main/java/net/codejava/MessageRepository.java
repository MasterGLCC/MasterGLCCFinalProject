package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByForum(Forum forum);
	List<Message> findByUser(User user);
	
}
