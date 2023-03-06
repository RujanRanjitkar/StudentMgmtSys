package com.example.studentmgmtsys.controller;

import com.example.studentmgmtsys.model.Student;
import com.example.studentmgmtsys.pojo.student.StudentDetailRequestPojo;
import com.example.studentmgmtsys.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentServiceImpl) {
        this.studentService = studentServiceImpl;
    }

//    @GetMapping("/students")
//    public String getStudent(Model model){
//        List<Student> students=studentService.getAllStudents();
//        model.addAttribute("students", students);
//        return "students";
//    }

    @GetMapping("/saveStudent")
    public String saveStudent() {
        return "saveStudent";
    }

    @GetMapping("/editStudent/{student_id}")
    public String editStudent(@PathVariable("student_id") Long student_id, Model model) {
        Student s=studentService.getStudentById(student_id);
        model.addAttribute("std",s);
        return "editStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudentDetail(@ModelAttribute StudentDetailRequestPojo studentDetailRequestPojo){
        studentService.saveStudentDetail(studentDetailRequestPojo);
        return "redirect:/user/home";
    }
}
