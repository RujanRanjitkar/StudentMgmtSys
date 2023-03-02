package com.example.studentmgmtsys.service.User;

import com.example.studentmgmtsys.model.Users;
import com.example.studentmgmtsys.pojo.User.UserDetailRequestPojo;
import com.example.studentmgmtsys.repo.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    public final UserRepo userRepo;
    public final ObjectMapper objectMapper;
    public final BCryptPasswordEncoder passwordEncode;

    @Override
    public void saveUserDetail(UserDetailRequestPojo userDetailRequestPojo){
        Users user;
        userDetailRequestPojo.setPassword(passwordEncode.encode(userDetailRequestPojo.getPassword()));
        userDetailRequestPojo.setRole("ROLE_USER");
        if(userDetailRequestPojo.getUser_id()!=null) {
            user = userRepo.findById(userDetailRequestPojo.getUser_id()).orElse(new Users());
        }
        user=objectMapper.convertValue(userDetailRequestPojo, Users.class);
        userRepo.save(user);
    }


}
