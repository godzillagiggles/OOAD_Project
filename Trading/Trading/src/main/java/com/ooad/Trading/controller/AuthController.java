package com.ooad.Trading.controller;

import com.ooad.Trading.model.Member;
import com.ooad.Trading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<Member> register(@RequestBody Member member) {
        logger.info("Received registration request: FirstName={}, LastName={}, Email={}",
                member.getFirstName(), member.getLastName(), member.getEmail());

        Member newUser = new Member();
        newUser.setFirstName(member.getFirstName());
        newUser.setLastName(member.getLastName());
        newUser.setEmail(member.getEmail());
        newUser.setPassword(member.getPassword());

        Member savedUser = userRepository.save(newUser);

        logger.info("New user registered successfully: ID={}, Email={}", savedUser.getId(), savedUser.getEmail());

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
