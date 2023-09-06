package com.kunal.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping("/getstudent")
    public String getStudentDetails(){
        return "Student1";
    }

    @PutMapping("/updatestudent")
    public String updateStudentDetails(){
        return "Updated student1";
    }

    @DeleteMapping("/deletestudent")
    public  String deleteStudentDetails(){
        return "Deleted student1";
    }
}
