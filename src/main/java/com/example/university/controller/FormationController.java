package com.example.university.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.model.Course;
import com.example.university.model.Formation;
import com.example.university.service.FormationService;

@RestController
public class FormationController {

    @Autowired
    FormationService formationService;

    @GetMapping("/formations")
    public List<Formation> getAllFormations() {
        return formationService.getAllFormations();
    }

    @GetMapping("/formations/{id}")
    public Optional<Formation> getFormationById(@PathVariable("id") Long id) {
        return formationService.getFormationById(id);
    }

    @GetMapping("/courses/{codeFormation}")
    public Optional<Course[]> getCoursesRelatedToFormation(@PathVariable("codeFormation") String codeFormation) {
        return formationService.getCoursesRelatedToFormation(codeFormation);
    }
}