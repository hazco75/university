package com.example.university.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.university.model.Formation;

@Repository
public interface FormationRepository extends CrudRepository<Formation,Long>{

}