package com.treinamentospring.treinamento_spring.Business;

import com.treinamentospring.treinamento_spring.Infrastructure.Entity.Usuario;
import com.treinamentospring.treinamento_spring.Infrastructure.Exceptions.ConflictException;
import com.treinamentospring.treinamento_spring.Infrastructure.Exceptions.ResourceNotFoundException;
import com.treinamentospring.treinamento_spring.Infrastructure.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;git add
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvaUsuario(Usuario usuario) {

        try {
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado " + e.getCause());
        }
    }

    public void emailExiste(String email) {
        boolean existe = usuarioRepository.existsByEmail(email);
        try {
            if (existe) {
                throw new ConflictException("Email " + email + " já cadastrado");
            }
        } catch (ConflictException e) {
            throw new ConflictException(e.getMessage() + e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscaUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email " + email + " não encontrado"));
    }

    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }
}
