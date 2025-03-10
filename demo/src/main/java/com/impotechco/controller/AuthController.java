package com.impotechco.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.impotechco.models.Usuario;
import com.impotechco.service.UsuarioService;

@CrossOrigin(origins = "http://127.0.0.1:5500") // Permitir conexión desde el frontend
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Optional<Usuario> user = usuarioService.buscarPorEmail(usuario.getEmail());
        if (user.isPresent() && user.get().getPassword().equals(usuario.getPassword())) {
            return "Login exitoso";
        } else {
            return "Error en usuario o contraseña";
        }
    }
}
