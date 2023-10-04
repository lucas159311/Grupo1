package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewPageController {
    @GetMapping("/nextPage")
    public String redirect(){
        return "nextPage";
    }
}
