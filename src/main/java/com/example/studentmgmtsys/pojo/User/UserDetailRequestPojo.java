package com.example.studentmgmtsys.pojo.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Service
public class UserDetailRequestPojo {

    private Integer user_id;

    private String username;

    private String email;

    private String address;

    private String password;

    private String role;

}
