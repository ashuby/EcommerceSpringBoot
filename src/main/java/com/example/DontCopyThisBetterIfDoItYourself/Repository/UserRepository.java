package com.example.DontCopyThisBetterIfDoItYourself.Repository;

import com.example.DontCopyThisBetterIfDoItYourself.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u where u.userName = :userName")
    User getUserByUserName(String userName);
}
