package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class HolaController {
    @GetMapping()
    public String inicio(){
        return "Hola está funcionando";
    }
}
