package com.example.happy_doggies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getHome(){
        System.out.println("You got home!");
        return "home";
    }
}