package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllers {

    @GetMapping("/")
    public String mostrarPaginaLogin() {
        return "login.html";
    }

    @GetMapping("/register")
    public String mostrarPaginaRegister() {
        return "register.html";
    }

    @GetMapping("/cliente")
    public String mostrarPaginaCliente() {
        return "cliente.html";
    }
}
