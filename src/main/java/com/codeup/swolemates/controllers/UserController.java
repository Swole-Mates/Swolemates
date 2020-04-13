package com.codeup.swolemates.controllers;


import com.codeup.swolemates.models.User;
import com.codeup.swolemates.repositories.UserRepo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepo userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo users, PasswordEncoder passwordEncoder) {
        this.userDao = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";

    }

    @GetMapping("/profile")
    public String profile(Model model) {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", u);
        return "/profile";
    }


    @GetMapping("/edit")
    public String edit(Model model) {
        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User u = userDao.getOne(loggedIn.getId());
        model.addAttribute("user", u);
        return "users/editProfile";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user) {
        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User updatedUser = userDao.getOne(loggedIn.getId());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setAge(user.getAge());
        String hash = passwordEncoder.encode(user.getPassword());
        updatedUser.setPassword(hash);
        userDao.save(updatedUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(updatedUser, updatedUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/profile";
    }
}