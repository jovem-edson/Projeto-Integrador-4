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

        Cavalo cavalo1 = new Cavalo("Ilirio", 4, "Trabalho", "Turcomeno", "Branco", "Fêmea", 1250.63F, true, "https://www.tenhomaisdiscosqueamigos.com/wp-content/uploads/2022/09/American-Idiot-Green-Day.jpg");
        Cavalo cavalo2 = new Cavalo("Relâmpago", 4, "Corrida", "Boliviano", "Marrom", "Macho", 1250.63F, false, "https://www.tenhomaisdiscosqueamigos.com/wp-content/uploads/2022/09/American-Idiot-Green-Day.jpg");

        Usuario usuario1 = new Usuario("login@email.com", "senha");

        cavaloRepository.saveAll(Arrays.asList(cavalo1, cavalo2));
        usuarioRepository.saveAll(List.of(usuario1));
    }
}
