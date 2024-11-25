package com.estabulo.estabulo.service.DB;

import com.estabulo.estabulo.model.Cavalo;
import com.estabulo.estabulo.model.Usuario;
import com.estabulo.estabulo.repository.CavaloRepository;
import com.estabulo.estabulo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private CavaloRepository cavaloRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public void instanciarDB() {

        Cavalo cavalo1 = new Cavalo("Ilirio", 4, "Trabalho", "Turcomeno", "Branco", "Fêmea", 1250.63F, true, "https://www.cabanhasantaedwiges.com.br/site/images/pais-da-cabanha/j-a-relampago.jpg");
        Cavalo cavalo2 = new Cavalo("Relâmpago", 4, "Corrida", "Boliviano", "Marrom", "Macho", 1250.63F, false, "https://img.freepik.com/fotos-premium/cavalo-galopante-irlandes-funileiro-egua-irlandesa-funileiro-equus-przewalskii-f-caballus_621486-3723.jpg");

        Usuario usuario1 = new Usuario("login@email.com", "senha");

        cavaloRepository.saveAll(Arrays.asList(cavalo1, cavalo2));
        usuarioRepository.saveAll(List.of(usuario1));
    }
}
