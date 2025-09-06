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
    @Transactional
    public void update(Student student, String field, String value) {

        Student tempStudent = findById(student.getId());

        switch (field.toUpperCase().trim()) {
            case "FIRST NAME" -> student.setFirstName(value);
            case "LAST NAME" -> student.setLastName(value);
            case "EMAIL" -> student.setEmail(value);
        }

        entityManager.merge(student);

    }

    @Override
    @Transactional
    public void update(int id, String field, String value) {

        Student tempStudent = findById(id);
        switch (field.toUpperCase().trim()) {
            case "FIRST NAME" -> tempStudent.setFirstName(value);
            case "LAST NAME" -> tempStudent.setLastName(value);
            case "EMAIL" -> tempStudent.setEmail(value);

        }
        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

        if  (findById(id) != null) {
            entityManager.remove(entityManager.find(Student.class, id));
        }
        else  {
            System.out.println("Student with id " + id + " not found");
        }

    }

    @Override
    @Transactional
    public void deleteAll() {

        entityManager.createQuery("DELETE FROM Student").executeUpdate();

    }
}
