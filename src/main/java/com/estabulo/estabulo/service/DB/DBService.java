package com.estabulo.estabulo.service.DB;

import com.estabulo.estabulo.model.Cavalo;
import com.estabulo.estabulo.repository.CavaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CavaloRepository cavaloRepository;

    @Bean
    public void instanciarDB() {

        Cavalo cavalo1 = new Cavalo("Ilirio", 4, "Trabalho", "Turcomeno", "Branco", "Fêmea", 1250.63F, true);
        Cavalo cavalo2 = new Cavalo("Relâmpago", 4, "Corrida", "Boliviano", "Marrom", "Macho", 1250.63F, false);

        cavaloRepository.saveAll(Arrays.asList(cavalo1, cavalo2));
    }
}
