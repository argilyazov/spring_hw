package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TemplateController {
    @GetMapping("hello")
    public String getHello(){
        return "templates/sample";
    }
}
