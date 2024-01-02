package com.azabellcode.blog.controller;

import com.azabellcode.blog.service.UserRepository;
import com.azabellcode.blog.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/checkUsernameAvailability")
    public String checkUsernameAvailability(@RequestParam String username) {
        // DB에서 해당 아이디(username)가 이미 존재하는지 확인
        User existingUser = userRepository.findByUsername(username);

        if (existingUser == null) {
            return "true"; // 아이디가 사용 가능한 경우
        } else {
            return "false"; // 아이디가 이미 존재하는 경우
        }
    }
}
