package com.codeup.swolemates.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @GetMapping("/")
    public String landing() {
        return "landing";
    }


    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

    @GetMapping("/about-us")
    public String us() { return "about-us"; }
}

