package com.splitwise.splitapp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.splitwise.splitapp.Models.User;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select * from users where users.phone=?1", nativeQuery = true)
    User getUser(String phoneNumber);
}