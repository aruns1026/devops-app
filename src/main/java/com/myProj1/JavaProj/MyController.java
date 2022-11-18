package com.myProj1.JavaProj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/stud/{id}")
    public Student myFunc(@PathVariable Integer id) {
        Student student = new Student();
        student.setId(id);
        student.setName("Jiva");
        student.setClas("5");
        return student;
    }
}
