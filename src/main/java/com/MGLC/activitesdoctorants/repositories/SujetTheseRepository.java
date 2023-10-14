package com.MGLC.activitesdoctorants.repositories;

import com.MGLC.activitesdoctorants.entities.Doctorant;
import com.MGLC.activitesdoctorants.entities.SujetThese;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface SujetTheseRepository extends JpaRepository<SujetThese, Integer>, JpaSpecificationExecutor<SujetThese> {

    default List<SujetThese> findByMotCles(EntityManager entityManager, String c1, String c2, int firstResult, int maxResult){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SujetThese> query = criteriaBuilder.createQuery(SujetThese.class);
        Root<SujetThese> root = query.from(SujetThese.class);
        List<Predicate> predicates = new ArrayList<>();
        if (c2 != null){
            Predicate predicate = criteriaBuilder.or(
                    criteriaBuilder.like(root.get("motCles"), "%" + c1 + "%" + c2 + "%"),
                    criteriaBuilder.like(root.get("motCles"), "%" + c2 + "%" + c1 + "%")
            );
            predicates.add(predicate);
        }else {
            Predicate predicate = criteriaBuilder.like(root.get("motCles"), "%" + c1 + "%" );
            predicates.add(predicate);
        }
        query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<SujetThese> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(firstResult); // Indique le premier résultat
        typedQuery.setMaxResults(maxResult);  // Limite le nombre de résultats

        return typedQuery.getResultList();
    }

    default Object count(EntityManager entityManager, String c1, String c2){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<SujetThese> root = query.from(SujetThese.class);
        Predicate predicate = criteriaBuilder.or(
                criteriaBuilder.like(root.get("motCles"), "%" + c1 + "%" + c2 + "%"),
                criteriaBuilder.like(root.get("motCles"), "%" + c2 + "%" + c1 + "%")
        );
        query.select(criteriaBuilder.count(root))
             .where(predicate);
        return entityManager.createQuery(query).getSingleResult();
    }
}
