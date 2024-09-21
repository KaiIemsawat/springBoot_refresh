package com.kai.springboot_rest_crud.rest;

import com.kai.springboot_rest_crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("Zukkii", "Iem"));
        students.add(new Student("Titann", "Iem"));
        students.add(new Student("Jon", "Doe"));
    }

    // define students endpoint "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}") // '{this}' <-- needs to match with the '@PathVariable
    public Student getStudentById(@PathVariable int studentId) {

        // Index into the list
        return students.get(studentId);
    }
}
