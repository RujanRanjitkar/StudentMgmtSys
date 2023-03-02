package com.example.studentmgmtsys.controller;

import com.example.studentmgmtsys.model.Student;
import com.example.studentmgmtsys.service.student.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.AttributedString;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final StudentService studentService;

    public UserController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public String home(Model model) {
//        return "redirect:/api/student/students";
        List<Student> students=studentService.getAllStudents();
        model.addAttribute("students", students);
        return "user/home";
    }

    @GetMapping(path="{student_id}")
    public String deleteStudent(@PathVariable("student_id") Long student_id){
        studentService.deleteStudent(student_id);
        return "redirect:/user/home";
    }
}
