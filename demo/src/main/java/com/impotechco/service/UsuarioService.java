package com.impotechco.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.impotechco.models.Usuario;
import com.impotechco.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;  // No debe ser estático

    @Autowired
    private PasswordEncoder passwordEncoder;  // Para encriptar la contraseña

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // Encripta la contraseña
        return usuarioRepository.save(usuario); // Guarda en la BD correctamente
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return Optional.ofNullable(usuarioRepository.findByEmail(email));
    }
}
