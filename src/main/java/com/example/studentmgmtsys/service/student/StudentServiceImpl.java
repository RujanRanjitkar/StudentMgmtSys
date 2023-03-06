package com.example.studentmgmtsys.service.student;

import com.example.studentmgmtsys.model.Student;
import com.example.studentmgmtsys.pojo.student.StudentDetailRequestPojo;
import com.example.studentmgmtsys.repo.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    public final StudentRepo studentRepo;
    public final StudentDetailRequestPojo studentDetailRequestPojo;
    public final ObjectMapper objectMapper;

    @Override
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @Override
    public  Student saveStudentDetail(StudentDetailRequestPojo studentDetailRequestPojo){
        Student student;
        if(studentDetailRequestPojo.getStudent_id()!=null) {
            student = studentRepo.findById(studentDetailRequestPojo.getStudent_id()).orElse(new Student());
        }
        student=objectMapper.convertValue(studentDetailRequestPojo, Student.class);
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long student_id){
        return studentRepo.findById(student_id).get();
    }
    @Override
    public void deleteStudent(Long student_id){
        studentRepo.deleteById(student_id);
    }
}
