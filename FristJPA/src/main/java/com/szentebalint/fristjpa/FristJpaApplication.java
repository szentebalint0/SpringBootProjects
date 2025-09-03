package com.szentebalint.fristjpa;

import com.szentebalint.fristjpa.dao.StudentDAO;
import com.szentebalint.fristjpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FristJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FristJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return args -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        Student student = new Student("Teszt", "Elek", "tesztelek@gmail.com");
        studentDAO.save(student);
        System.out.println("Student created successfully with id: " + student.getId());

    }

}
