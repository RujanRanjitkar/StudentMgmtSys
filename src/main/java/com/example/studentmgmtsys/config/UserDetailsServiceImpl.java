package com.example.studentmgmtsys.config;

import com.example.studentmgmtsys.model.Users;
import com.example.studentmgmtsys.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepo.findByEmail(email);

        if (user != null) {
            return new CustomerUserDetails(user);
        }

        throw new UsernameNotFoundException("user not available");
    }

}
