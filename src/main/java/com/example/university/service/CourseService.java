package com.example.university.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.model.Course;
import com.example.university.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses () {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach( course -> courses.add(course));
        return courses;
    }

}