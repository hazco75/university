package com.example.university.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.model.Formation;
import com.example.university.model.Student;
import com.example.university.service.StudentService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/students")
    private List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    private Optional<Student> getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students2/{degree}")
    private Optional<Student[]> getStudentsByDegree(@PathVariable("degree") String degree) {
        return studentService.getStudentByDegree(degree);
    }
    
    @PostMapping("/students")
    private void addStudent(@RequestBody Student newStudent) {
        studentService.addStudent(newStudent);
    }

    @PostMapping("/formation/{studentId}")
    private void subscribeStudentToFormation(@PathVariable("studentId") Long studentId, @RequestBody Formation formation) {
        System.out.println(formation.getCodeFormation());
        System.out.println(studentId);
        studentService.subscribeStudentToFormation(studentId, formation);
    }

    @PostMapping("/formation/unsubscribe/{studentId}")
    private void unsubscribeStudentToFormation(@PathVariable("studentId") Long studentId) {
        System.out.println(studentId);
        studentService.unsubscribeStudentToFormation(studentId);
    }

    @DeleteMapping("/students/{id}")
    private void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }
}