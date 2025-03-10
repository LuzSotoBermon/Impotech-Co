package com.impotechco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import java.util.UUID;

import com.impotechco.models.Usuario;
import com.impotechco.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // Encripta la contraseña
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email); 
    }
    

    public Optional<Usuario> autenticarUsuario(String email, String password) {
        Optional<Usuario> usuarioOpt = buscarPorEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (passwordEncoder.matches(password, usuario.getPassword())) { // Verifica contraseña
                usuario.setSessionToken(UUID.randomUUID().toString()); // Genera un token de sesión único
                usuarioRepository.save(usuario); // Guarda el usuario con el nuevo token
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }
}
