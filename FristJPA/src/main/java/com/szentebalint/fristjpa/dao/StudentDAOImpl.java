package com.szentebalint.fristjpa.dao;

import com.szentebalint.fristjpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
         entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return  entityManager.find(Student.class, id);
    }

    @Override
    public Student findByName(String name) {
        return  entityManager.find(Student.class, name);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> studentQuery = entityManager.createQuery("FROM Student", Student.class);

        return studentQuery.getResultList();
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteAll() {

    }
}
