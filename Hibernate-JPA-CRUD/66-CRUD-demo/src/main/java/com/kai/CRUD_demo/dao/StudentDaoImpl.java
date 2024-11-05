package com.kai.CRUD_demo.dao;

import com.kai.CRUD_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> query =
                entityManager.createQuery("FROM Student order BY firstName DESC", Student.class);
        // 'Student' <- uppercase 'S' as entity classname

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> query =
                entityManager.createQuery("FROM Student WHERE lastName = :data", Student.class);
        // ':data' <- JPQL named parameters are prefixed with a colon ':'

        query.setParameter("data", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteAll() {
        int numsOfDeletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println(numsOfDeletedRows + " students were deleted");
    }

}
