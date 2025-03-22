package com.springSecurity.spring.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentController {
    List<Student>Students=new ArrayList<>(List.of(
            new Student(1,"raunak","java"),
            new Student(2,"ram","html")
    ));
 @GetMapping("csrf-token")
    public CsrfToken getcsrftoken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }
    @GetMapping("/students")
    public List<Student>getALLStudent(){
        return Students;
    }
    @PostMapping("/students")
    public void addStudent(@RequestBody Student stu){
        Students.add(stu);
    }
}
