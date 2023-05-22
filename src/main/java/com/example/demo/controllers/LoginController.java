package com.example.demo.controllers;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.models.UsuarioModel;
import com.google.common.hash.Hashing;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    @ResponseBody
    public String login(@ModelAttribute UsuarioModel loginForm) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        if (email != null && password != null) {
            UsuarioModel usuario = usuarioRepository.findByEmail(email);

            if (usuario == null) {
                return "Correo electrónico no válido";
            }

            String storedPasswordHash = usuario.getPassword();
            String passwordHash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

            if (passwordHash.equals(storedPasswordHash)) {
                return "Inicio de sesión exitoso";
            } else {
                return "Contraseña incorrecta";
            }
        } else {
            return "Datos de inicio de sesión incompletos";
        }
    }

    @PostMapping("/verificar-humanidad")
    @ResponseBody
    public String verificarHumanidad(@RequestParam("respuesta") String respuesta) {
        // Aquí puedes agregar la lógica para verificar la respuesta de la pregunta de humanidad
        if (respuesta.equals("4")) {
            // La respuesta es correcta, puedes realizar el proceso de inicio de sesión
            return "OK";
        } else {
            // La respuesta es incorrecta, puedes mostrar un mensaje de error o redirigir a una página de error
            return "Respuesta incorrecta";
        }
    }
}
