package com.example.studentmgmtsys.repo;

import com.example.studentmgmtsys.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    public boolean existsByEmail(String email);
    public Users findByEmail(String email);
}
