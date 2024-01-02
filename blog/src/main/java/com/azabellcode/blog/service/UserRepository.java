package com.azabellcode.blog.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azabellcode.blog.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
