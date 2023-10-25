package com.glcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glcc.models.Commentaire;

public interface ICommentaireRepository extends JpaRepository<Commentaire,Long> {
	@Query(nativeQuery=true,value="insert into commentaire (commentaire, id_etat) values (?1,?2)")
	void addcomment(String commentaire,Long id);
}
