package com.codeup.swolemates.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

    @GetMapping("/search")
    @ResponseBody
    public String search(){return "This page is used to search for swole mates"; }

    @GetMapping("/results")
    @ResponseBody
    public String results(){return "This page returns matches";}
}
