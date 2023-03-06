package com.example.studentmgmtsys.service.User;

import com.example.studentmgmtsys.pojo.User.UserDetailRequestPojo;

public interface UserService {

    public boolean checkEmail(String email);
    public void saveUserDetail(UserDetailRequestPojo userDetailRequestPojo);

}
