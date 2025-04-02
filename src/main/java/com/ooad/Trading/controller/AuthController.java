package com.ooad.Trading.controller;

import com.ooad.Trading.model.Member;
import com.ooad.Trading.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Returns login.html from templates
    }

    @PostMapping("/signup")
    @ResponseBody
    public String signup(@RequestBody Member member) {
        Optional<Member> existingMember = memberRepository.findByEmail(member.getEmail());
        if (existingMember.isPresent()) {
            return "User already exists!";
        }
        memberRepository.save(member);
        return "Signup successful!";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam(required = false) String email,
                        @RequestParam(required = false) String password) {
        if (email == null || password == null) {
            return "Missing email or password!";
        }

        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent() && member.get().getPassword().equals(password)) {
            return "Login successful!";
        }
        return "Invalid credentials!";
    }

}