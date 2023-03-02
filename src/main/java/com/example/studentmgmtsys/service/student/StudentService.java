package com.example.studentmgmtsys.service.student;

import com.example.studentmgmtsys.model.Student;
import com.example.studentmgmtsys.pojo.student.StudentDetailRequestPojo;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudentDetail(StudentDetailRequestPojo studentDetailRequestPojo);

    void deleteStudent(Long student_id);
}
