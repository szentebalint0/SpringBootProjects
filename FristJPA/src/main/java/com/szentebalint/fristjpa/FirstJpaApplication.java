package com.szentebalint.fristjpa;

import com.szentebalint.fristjpa.dao.StudentDAO;
import com.szentebalint.fristjpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FirstJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return args -> createMultipleStudents(studentDAO);
    }


    private void createStudent(StudentDAO studentDAO) {

        Student student = new Student("Teszt", "Elek", "tesztelek@gmail.com");
        studentDAO.save(student);
        System.out.println("Student created successfully with id: " + student.getId());

    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        Student student1 = new Student("John", "Doe", "john@doe.com");
        Student student2 = new Student("Ex", "Ample", "ex@mple.com");
        Student student3 = new Student("Papa", "John", "john@papa.com");

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("Students created successfully with ids of: "
                            + student1.getId() +  " and "
                            + student2.getId() + " and "
                            + student3.getId());
    }

    private void printDatabase(StudentDAO studentDAO) {

        List<Student> students = studentDAO.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

    }

    private void updateStudent(StudentDAO studentDAO) {

        studentDAO.update(5, "email", "renamedexaple@test.com");

        System.out.println("Student updated successfully with id: " + studentDAO.findById(5));

    }

    private void deleteStudent(StudentDAO studentDAO) {

        studentDAO.deleteById(5);
        System.out.println("Student deleted successfully with id: 5");

    }

    private void clearDatabase(StudentDAO studentDAO) {
        studentDAO.deleteAll();
        System.out.println("All students deleted successfully");
    }

}
