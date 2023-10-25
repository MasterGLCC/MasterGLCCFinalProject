package com.glcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.glcc.models.Etat_avancement;
import com.glcc.models.Doctorant;
import java.util.List;
@Repository
public interface IEtatRepository extends JpaRepository<Etat_avancement,Long>{
	@Query(nativeQuery = true, value = "SELECT e.id_etat, d.nom, e.date, e.titre, e.note, s.titre "
	        + "FROM etat_avancement e "
	        + "JOIN sujet s ON e.id_th = s.id_th "
	        + "JOIN doctorant d ON s.id_doc = d.identifiant "
	        + "JOIN professeur p ON s.id_prof = p.identifiant "
	        + "WHERE p.identifiant = ?1 "
	        + "AND (d.identifiant, e.date) IN (SELECT s2.id_doc, MAX(e2.date) FROM etat_avancement e2 "
	        + "                                 JOIN sujet s2 ON e2.id_th = s2.id_th "
	        + "                                 WHERE s2.id_prof = p.identifiant "
	        + "                                 GROUP BY s2.id_doc)")
	List<Object[]> findEtatByProfLog(Long id);
	@Query(nativeQuery=true,value="select s.id_th, s.titre, d.nom from sujet s join doctorant d on d.identifiant=s.id_doc join professeur p on p.identifiant=s.id_prof where p.identifiant=?1")
    List<Object[]> findDoctorantEtatByProfLog(Long id);
    
    @Query(nativeQuery=true,value="select d.cin,s.id_th,s.titre,s.description,s.mots_cles, e.id_etat from sujet s join doctorant d on d.identifiant=s.id_doc join etat_avancement e on s.id_th=e.id_th where e.id_etat=?1")
    List<Object[]> findDoctorantSujById(Long id);
     
    @Query(nativeQuery=true,value="select id_th from etat_avancement where id_etat=?1")
    Long findIdSujet(Long id);
    
    @Query(nativeQuery=true,value="select * from etat_avancement where id_th=?1")
    List<Etat_avancement[]> findEtatBySujet(Long id);
    //Etat_avancement findEtatBySujet(Long id);
    @Query(nativeQuery=true,value="select * from etat_avancement where id_etat=?1")
    Etat_avancement findEtatById(Long id);
    @Query(nativeQuery=true,value="update etat_avancement set note=?1 where id_etat=?2")
    Etat_avancement updateNote(int note,Long id);

    @Query(nativeQuery=true,value="select * from etat_avancement where id_th=?1")
    List<Etat_avancement> findByIdTh(Long id);
}
