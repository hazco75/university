package com.example.university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.model.Course;
import com.example.university.model.Formation;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.FormationRepository;

@Service
public class FormationService {

    @Autowired
    FormationRepository formationRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<Formation> getAllFormations() {
        List<Formation> formations = new ArrayList<>();
        formationRepository.findAll().forEach(formation -> formations.add(formation));
        return formations;
    }

    public Optional<Formation> getFormationById(Long id) {
        return formationRepository.findById(id);
    }

    //@Query(value = "select * from COURSES where CODE_FORMATION = ?1")
    public Optional<Course[]> getCoursesRelatedToFormation(String codeFormation) {
        return courseRepository.findCourseByCodeFormation(codeFormation);
    }
}