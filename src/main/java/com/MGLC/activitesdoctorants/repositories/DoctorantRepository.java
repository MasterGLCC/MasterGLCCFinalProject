package com.MGLC.activitesdoctorants.repositories;

import com.MGLC.activitesdoctorants.entities.Doctorant;
import com.MGLC.activitesdoctorants.entities.Personne;
import com.MGLC.activitesdoctorants.entities.Professeur;
import com.MGLC.activitesdoctorants.entities.SujetThese;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface DoctorantRepository extends JpaRepository<Doctorant, Integer>, JpaSpecificationExecutor<Doctorant> {

    default List<Doctorant> findByNomOrPrenom(EntityManager entityManager, String c1, String c2, int firstResult, int maxResult) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Doctorant> criteriaQuery = criteriaBuilder.createQuery(Doctorant.class);
        Root<Doctorant> root = criteriaQuery.from(Doctorant.class);

        List<Predicate> predicates = new ArrayList<>();
        if (c1 != null) {
            predicates.add(
                    criteriaBuilder.or(
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("nom")), "%" + c1.toLowerCase() + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("prenom")), "%" + c1.toLowerCase() + "%")
                    )
            );
        }
        if( c2 != null ){
            predicates.add(
                    criteriaBuilder.or(
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("prenom")), "%" + c2.toLowerCase() + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("nom")), "%" + c2.toLowerCase() + "%")
                    )
            );
        }
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<Doctorant> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(firstResult); // Indique le premier résultat
        typedQuery.setMaxResults(maxResult);  // Limite le nombre de résultats

        return typedQuery.getResultList();
    }

    default Object count(EntityManager entityManager, String c1, String c2) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Object.class);
        Root<Doctorant> root = criteriaQuery.from(Doctorant.class);

        List<Predicate> predicates = new ArrayList<>();
        if (c1 != null) {
            predicates.add(
                    criteriaBuilder.or(
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("nom")), "%" + c1.toLowerCase() + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("prenom")), "%" + c1.toLowerCase() + "%")
                    )
            );
        }
        if( c2 != null ){
            predicates.add(
                    criteriaBuilder.or(
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("prenom")), "%" + c2.toLowerCase() + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("nom")), "%" + c2.toLowerCase() + "%")
                    )
            );
        }
        criteriaQuery.select(criteriaBuilder.count(root))
                     .where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

        Object result;
        try {
            result = entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException e) {
            result = 0L;
        }
        return result;
    }
}
