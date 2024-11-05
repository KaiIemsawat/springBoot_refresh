package com.kai.CRUD_demo.dao;

import com.kai.CRUD_demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAllStudents();

    List<Student> findByLastName(String lastNam);

    void update(Student student);

    void delete(Integer id);

    void deleteAll();
}
