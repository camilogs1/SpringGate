package com.example.demo.controllers;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.models.UsuarioModel;
import com.google.common.hash.Hashing;

@RestController
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(@RequestBody UsuarioModel loginForm) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        com.example.demo.models.UsuarioModel usuario = usuarioRepository.findByemail(email);

        if (usuario == null) {
            // No se encontró un registro para el email electrónico proporcionado
            return "email electrónico no válido";
        }

        String storedPasswordHash = usuario.getPassword();

        // Generar el hash de la contraseña proporcionada
        String passwordHash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        if (passwordHash.equals(storedPasswordHash)) {
            return "Ingreso exitoso";
        } else {
            // Contraseña incorrecta
            return "Contraseña incorrecta";
        }
    }
}