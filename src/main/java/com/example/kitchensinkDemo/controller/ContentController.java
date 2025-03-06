package com.example.kitchensinkDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("api/kitchensink/register")
    public String signup(){
        return "register";
    }

}
