package com.estabulo.estabulo.repository;

import com.estabulo.estabulo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.email = ?1 AND usuario.senha = ?2")
    List<Usuario> login(String email, String senha);

}

