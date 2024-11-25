package com.estabulo.estabulo.controller;

import com.estabulo.estabulo.model.Usuario;
import com.estabulo.estabulo.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value="/usuario")
@CrossOrigin(origins = "*", maxAge = 33600)

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Usuario> gravarUsuario(@RequestBody Usuario usuario) {
        usuario = usuarioService.gravarUsuario(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody Usuario usuario) {
        try {
            List<Usuario> resultado = usuarioService.login(usuario);

            if (resultado == null || resultado.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new ErrorResponse("Credenciais Inválidas"));
            }

            return ResponseEntity.ok(resultado.get(0));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("credenciais invalidas"));
        }
    }

    public static class ErrorResponse {
        private String resposta;

        public ErrorResponse(String resposta) {
            this.resposta = resposta;
        }

        public String getResposta() {
            return resposta;
        }

        public void setResposta(String resposta) {
            this.resposta = resposta;
        }
    }
}
