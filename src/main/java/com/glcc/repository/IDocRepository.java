package com.glcc.repository;

import org.springframework.data.repository.CrudRepository;

import com.glcc.models.Doctorant;

public interface IDocRepository extends CrudRepository<Doctorant, Long> {

}
