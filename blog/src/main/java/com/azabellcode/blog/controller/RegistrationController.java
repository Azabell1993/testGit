package com.azabellcode.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.azabellcode.blog.service.UserRepository;
import com.azabellcode.blog.user.User;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String registration() {
        return "thymeleaf/registration";
    }

    @PostMapping("/registration")
    public String processRegistration(
                                        @RequestParam String nickname,
                                        @RequestParam String username,
                                        @RequestParam String password,
                                        @RequestParam String emailLocalPart,
                                        @RequestParam String emailDomain,
                                        @RequestParam("customEmailDomain") String customEmailDomain) {
        String finalEmailDomain = (emailDomain.equals("custom")) ? customEmailDomain : emailDomain;
    
        User user = new User();
        user.setNickname(nickname);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmailLocalPart(emailLocalPart);
        user.setEmailDomain(finalEmailDomain); // finalEmailDomain을 사용
        user.setEnabled(true);
        userRepository.save(user);
        return "redirect:/index";
    }
}