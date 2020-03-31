package com.codeup.swolemates.controllers;

import com.codeup.swolemates.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user",new User());
        return "users/sign-up";
    }

//    @PostMapping("/sign-up")
//    public String saveUser(@ModelAttribute User user){
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
//        return "redirect:/login";
//    }
}
