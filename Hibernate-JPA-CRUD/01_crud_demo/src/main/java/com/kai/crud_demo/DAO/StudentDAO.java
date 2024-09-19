package com.kai.crud_demo.DAO;

import com.kai.crud_demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAllStudent();

    List<Student> findByLastname(String lastname);

    void update(Student student);


}
