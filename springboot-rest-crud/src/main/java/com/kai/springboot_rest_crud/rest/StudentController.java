package com.kai.springboot_rest_crud.rest;

import com.kai.springboot_rest_crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("No student with this ID found");
        }

        return students.get(studentId);
    }


}
