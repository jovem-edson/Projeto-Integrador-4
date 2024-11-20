package com.estabulo.estabulo.service.usuario;

import com.estabulo.estabulo.model.Usuario;
import com.estabulo.estabulo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario gravarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> login(Usuario usuario) {
        return usuarioRepository.login(usuario.getEmail(), usuario.getSenha());
    }
}
