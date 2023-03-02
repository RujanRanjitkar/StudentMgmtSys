package com.example.studentmgmtsys.controller;

import com.example.studentmgmtsys.model.Student;
import com.example.studentmgmtsys.pojo.student.StudentDetailRequestPojo;
import com.example.studentmgmtsys.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/student")
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

    @PostMapping
    public void saveStudentDetail(@RequestBody StudentDetailRequestPojo studentDetailRequestPojo){
        studentService.saveStudentDetail(studentDetailRequestPojo);
    }


}
