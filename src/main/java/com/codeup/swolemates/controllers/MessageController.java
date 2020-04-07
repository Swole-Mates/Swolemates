package com.codeup.swolemates.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
    @GetMapping("/messages")
    @ResponseBody
    public String messages(){return "This page will display messages with other users";}
}
