package com.glcc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.glcc.repository.IEtatRepository;
import com.glcc.repository.ICommentaireRepository;
import com.glcc.models.Commentaire;
import com.glcc.models.Etat_avancement;
@Service
@Transactional
public class CommentaireService {

	@Autowired
	ICommentaireRepository crepo;
	@Autowired
	IEtatRepository erepo;
	
	public void ajoutCommentaire(String commentaire, Long id) {
		Etat_avancement et = erepo.findEtatById(id);
		Commentaire com = new Commentaire();
		com.setEtat(et);
		com.setCommentaire(commentaire);
		this.crepo.save(com);
	}
	public Commentaire addComment(Commentaire com) {
		return crepo.save(com);
	}
}
