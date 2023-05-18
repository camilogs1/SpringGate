package com.example.demo.controllers;

import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;
import com.google.common.hash.Hashing;

@RestController
public class RegisterController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/register")
    public String register(@RequestBody UsuarioModel registerForm) {
        String nombre = registerForm.getNombre();
        Integer prioridad = registerForm.getPrioridad();
        String email = registerForm.getEmail();
        String password = registerForm.getPassword();

        // Generar el hash de la contraseña
        String passwordHash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        // Crear un nuevo usuario
        UsuarioModel usuario = new UsuarioModel(nombre, prioridad, email, passwordHash);

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);

        return "cliente.html";
    }
}