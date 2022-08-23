package com.example.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.model.Course;
import com.example.university.service.CourseService;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;
    

    @GetMapping("/courses")
    private List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

}