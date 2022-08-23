package com.example.university.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.university.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long>{
    
    @Query(value = "SELECT * from COURSE where CODE_FORMATION = ?1", nativeQuery = true)
    Optional<Course[]> findCourseByCodeFormation(String codeFormation);

}