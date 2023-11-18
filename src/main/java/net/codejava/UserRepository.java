package net.codejava;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);
	public User findByCin(String cin);
	//public Optional<User> findById(Long id);
	 public User findByUsername(String username); 
	 List<User> findAllByIdNot(Long id);
	 
	 
	
	
}
