package com.example.studentmgmtsys.pojo.student;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Service
public class StudentDetailRequestPojo {
    private Long student_id;

    private String student_name;

    private LocalDate dob;

    private Long phone;

    private String email;

    private String address;
}