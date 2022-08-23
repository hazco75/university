package com.example.university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.model.Formation;
import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student[]> getStudentByDegree(String degree) {
        return studentRepository.findStudentsByDegree(degree);
    }

    public void addStudent(Student newStudent) {
        studentRepository.save(newStudent);
    }

    public void subscribeStudentToFormation(Long studentId, Formation formation) {
        studentRepository.subscribeStudentToFormation(formation, studentId);
    }

    public void unsubscribeStudentToFormation(Long studentId) {
        studentRepository.unsubscribeStudentToFormation(studentId);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}