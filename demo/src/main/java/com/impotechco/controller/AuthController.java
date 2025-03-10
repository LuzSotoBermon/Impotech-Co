package com.impotechco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.impotechco.models.Usuario;
import com.impotechco.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://impotechco.great-site.net") 
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint para iniciar sesión.
     * @param credentials Mapa con email y password.
     * @return ResponseEntity con mensaje y token de sesión.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<Usuario> usuarioOpt = usuarioService.autenticarUsuario(email, password);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login exitoso");
            response.put("token", usuario.getSessionToken());
            response.put("email", usuario.getEmail());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }

    /**
     * Endpoint para cerrar sesión.
     * @param request Mapa con el email del usuario.
     * @return ResponseEntity con el resultado de la operación.
     */
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody Map<String, String> request) {
        String email = request.get("email");

        Optional<Usuario> usuarioOpt = usuarioService.buscarPorEmail(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setSessionToken(null); // Elimina el token de sesión
            usuarioService.registrarUsuario(usuario);
            return ResponseEntity.ok("Sesión cerrada correctamente");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al cerrar sesión");
    }

    /**
     * Endpoint para registrar un nuevo usuario.
     * @param usuario Objeto con los datos del usuario.
     * @return ResponseEntity con el usuario creado o error.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioService.buscarPorEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El email ya está registrado");
        }

        Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
