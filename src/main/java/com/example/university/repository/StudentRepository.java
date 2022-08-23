package com.example.university.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.university.model.Formation;
import com.example.university.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    @Query(value = "select * from STUDENT where DEGREE = ?1", nativeQuery = true) /* AND FORMATION_ID is null */
    Optional<Student[]> findStudentsByDegree(String degree);

    @Modifying
    @Transactional
    @Query(value = "update STUDENT set FORMATION_ID = ? where ID = ?", nativeQuery = true)
    int subscribeStudentToFormation(Formation formation, Long id);

    @Modifying
    @Transactional
    @Query(value = "update STUDENT set FORMATION_ID = null where ID = ? ", nativeQuery = true)
    int unsubscribeStudentToFormation(Long id);
}