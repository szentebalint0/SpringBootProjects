package com.szentebalint.fristjpa.dao;

import com.szentebalint.fristjpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    Student findByName(String name);

    List<Student> findAll();

    void update(Student student, String field, String value);

    void update(int id, String field, String value);

    void deleteById(Integer id);

    void deleteAll();

}
