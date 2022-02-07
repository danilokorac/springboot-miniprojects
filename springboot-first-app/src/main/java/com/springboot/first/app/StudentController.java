package com.springboot.first.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping(path = "/student")
    public Student getStudent(){
        return new Student("Danilo","Korac");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();
        students.add(new Student("Marko","Djordjevic"));
        students.add(new Student("Ivan","Krstic"));
        students.add(new Student("Nikola","Tomic"));
        students.add(new Student("Jovan","Govedarica"));
        students.add(new Student("Nenad","Penezic"));

        return  students;
    }

}
