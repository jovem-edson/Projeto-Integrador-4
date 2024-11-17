package com.estabulo.estabulo.controller;

import com.estabulo.estabulo.model.Cavalo;
import com.estabulo.estabulo.service.cavalo.CavaloService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value="/cavalo")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58386", "http://localhost:61000", "http://localhost:61357", "http://localhost:61562", "http://localhost:63139", "http://localhost:65032"})

public class EstabuloController {
    @Autowired
    private CavaloService cavaloService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Cavalo> findById(@PathVariable Integer id) {
        Cavalo cavalo = cavaloService.findById(id);
        return ResponseEntity.ok().body(cavalo);
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Cavalo> findByNome(@PathVariable String nome) {
        Cavalo cavalo = cavaloService.findByNome(nome);
        return ResponseEntity.ok().body(cavalo);
    }

    @GetMapping(value = "/raca/{raca}")
    public ResponseEntity<Cavalo> listarPorRaca(@PathVariable String raca) {
        Cavalo cavalo = cavaloService.listarPorRaca(raca);
        return ResponseEntity.ok().body(cavalo);
    }

    @GetMapping(value = "/tipo/{tipo}")
    public ResponseEntity<Cavalo> listarPorTipo(@PathVariable String tipo) {
        Cavalo cavalo = cavaloService.listarPorTipo(tipo);
        return ResponseEntity.ok().body(cavalo);
    }

    @GetMapping(value = "/disponiveis")
    public ResponseEntity<List<Cavalo>> listarAbertos() {
        List<Cavalo> cavalos = cavaloService.listarTodosDisponiveisParaCompra();

        return ResponseEntity.ok().body(cavalos);
    }

    @GetMapping(value = "/indisponiveis")
    public ResponseEntity<List<Cavalo>> listarFechados() {
        List<Cavalo> cavalos = cavaloService.listarTodosIndisponiveisParaCompra();

        return ResponseEntity.ok().body(cavalos);
    }

    // READ
    @GetMapping
    public List<Cavalo> findAll() {
        List<Cavalo> cavalo = cavaloService.findAll();
        return cavalo;
    }

    // CREATE
    // Método para cadastrar o cavalo com imagem
    @PostMapping
    public ResponseEntity<Cavalo> gravarCavalo(
            @RequestParam("nome") String nome,
            @RequestParam("idade") int idade,
            @RequestParam("tipo") String tipo,
            @RequestParam("raca") String raca,
            @RequestParam("pelagem") String pelagem,
            @RequestParam("genero") String genero,
            @RequestParam("preco") float preco,
            @RequestParam("disponivelParaCompra") boolean disponivelParaCompra,
            @RequestParam("imagem") MultipartFile imagem) throws IOException {

        if (imagem.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        // Gerar o nome do arquivo da imagem
        String imageName = imagem.getOriginalFilename();

        // Definir o diretório onde as imagens serão salvas
        String uploadDir = "uploads/";
        File uploadDirectory = new File(uploadDir);
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdir();
        }

        Path imagePath = Paths.get(uploadDir + imageName);
        Files.write(imagePath, imagem.getBytes());

        // A URL completa da imagem
        String imageUrl = "http://localhost:8080/uploads/" + imageName;

        // Criar o objeto Cavalo
        Cavalo cavalo = new Cavalo(nome, idade, tipo, raca, pelagem, genero, preco, disponivelParaCompra, imageUrl);

        // Salvar o cavalo no banco de dados
        cavalo = cavaloService.gravarCavalo(cavalo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cavalo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(cavalo);
    }




    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        cavaloService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Cavalo cavalo) {
        Cavalo alterado = cavaloService.update(id, cavalo);

        return ResponseEntity.noContent().build();
    }

}
