package com.glcc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glcc.models.Fichier;

public interface IFichierRepostory extends JpaRepository<Fichier,Long>{
    Fichier findByName(String name);

    @Query(nativeQuery=true,value="select * from fichier where id_etat=?1")
    Fichier findFileById(Long id);
}
