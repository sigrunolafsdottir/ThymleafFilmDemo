package com.example.thymleaffilmdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormGreetingController {

    @RequestMapping("formGreeting")
    public String formGreeting(){
        return "formGreetingStart.html";
    }

    @PostMapping("formGreetingReceival")
    public String formGreetingReceiver(@RequestParam String fname,
                                       @RequestParam String lname, Model model){
        model.addAttribute("fname", fname);
        model.addAttribute("lname", lname);
        return "formGreetingThanks.html";
    }

}