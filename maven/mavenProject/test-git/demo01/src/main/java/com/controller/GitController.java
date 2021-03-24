package com.controller;

import com.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitController {


    @RequestMapping("/demo")
    public Student demo() {
        Student s = new Student() ;
        s.setName("王五") ;
        return  s;
    }
}
