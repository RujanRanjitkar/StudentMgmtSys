package com.example.studentmgmtsys.service.student;

import com.example.studentmgmtsys.model.Student;
import com.example.studentmgmtsys.pojo.student.StudentDetailRequestPojo;
import com.example.studentmgmtsys.repo.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
    public final StudentRepo studentRepo;
    public final StudentDetailRequestPojo studentDetailRequestPojo;
    public final ObjectMapper objectMapper;

    @Override
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @Override
    public  void saveStudentDetail(StudentDetailRequestPojo studentDetailRequestPojo){
        Student student;
        if(studentDetailRequestPojo.getStudent_id()!=null) {
            student = studentRepo.findById(studentDetailRequestPojo.getStudent_id()).orElse(new Student());
        }
        student=objectMapper.convertValue(studentDetailRequestPojo, Student.class);
        studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long student_id){
        boolean exists=studentRepo.existsById(student_id);
        if(!exists){
            throw new IllegalStateException("student with id "+ student_id +" does not exists");
        }
        studentRepo.deleteById(student_id);
    }
}
