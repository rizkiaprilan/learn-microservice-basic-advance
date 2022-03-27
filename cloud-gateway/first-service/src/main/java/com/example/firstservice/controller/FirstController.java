package com.example.firstservice.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class FirstController {

    @GetMapping("/message")
    @ResponseBody
    public String test(@RequestHeader("first-request") String header) {
        System.out.println(header);
        return "Hello JavaInUse Called in First Service";
    }
}
