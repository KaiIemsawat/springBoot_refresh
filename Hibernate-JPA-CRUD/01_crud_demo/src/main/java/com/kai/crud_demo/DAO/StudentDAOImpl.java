package com.kai.crud_demo.DAO;

import com.kai.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudent() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastname desc", Student.class);
        // "FROM Student" <-- not the name of the database table. Name based on entity name and entity field

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastname(String lastname) {
        // Create query
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastname = :data", Student.class
                // JPQL named parameters are prefixed with a colon ':'
        );

        // Set query parameters
        query.setParameter("data", lastname);

        // Return query results
        return query.getResultList();
    }


}
