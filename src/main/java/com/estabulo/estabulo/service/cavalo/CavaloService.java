package com.estabulo.estabulo.service.cavalo;

import com.estabulo.estabulo.model.Cavalo;
import com.estabulo.estabulo.repository.CavaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CavaloService {
    @Autowired
    CavaloRepository cavaloRepository;

    public Cavalo findById(Integer id) {
        Optional<Cavalo> cavalo = cavaloRepository.findById(id);
        return cavalo.orElse(null);
    }

    public Cavalo findByNome(String nome) {
        List<Cavalo> cavalos = cavaloRepository.findByNome(nome);

        if (!cavalos.isEmpty()) {
            return cavalos.get(0); // Retorna o primeiro cavalo se existir
        }
        return null; // Retorna null se não houver cavalos com esse nome
    }

    public Cavalo listarPorTipo(String tipo) {
        List<Cavalo> cavalos = cavaloRepository.listarPorTipo(tipo);

        if (!cavalos.isEmpty()) {
            return cavalos.get(0); // Retorna o primeiro cavalo se existir
        }
        return null; // Retorna null se não houver cavalos com esse tipo
    }

    public Cavalo listarPorRaca(String raca) {
        List<Cavalo> cavalos = cavaloRepository.listarPorRaca(raca);

        if (!cavalos.isEmpty()) {
            return cavalos.get(0); // Retorna o primeiro cavalo se existir
        }
        return null; // Retorna null se não houver cavalos com essa raca
    }

    public List<Cavalo> listarTodosDisponiveisParaCompra() {
        List<Cavalo> cavalos = cavaloRepository.listarTodosDisponiveisParaCompra();
        return cavalos;
    }

    public List<Cavalo> listarTodosIndisponiveisParaCompra() {
        List<Cavalo> cavalos = cavaloRepository.listarTodosIndisponiveisParaCompra();
        return cavalos;
    }

    public List<Cavalo> findAll() {
        List<Cavalo> cavalos = cavaloRepository.findAll();
        return cavalos;
    }

    public Cavalo gravarCavalo(Cavalo cavalo) {
        return cavaloRepository.save(cavalo);
    }

    public void deletar(Integer id) {
        cavaloRepository.deleteById(id);
    }

    public Cavalo update(Integer id, Cavalo cavalo) {
        Cavalo alterado = findById(id);
        if (alterado != null) {
            alterado.setNome(cavalo.getNome());
            alterado.setIdade(cavalo.getIdade());
            alterado.setTipo(cavalo.getTipo());
            alterado.setRaca(cavalo.getRaca());
            alterado.setPelagem(cavalo.getPelagem());
            alterado.setGenero(cavalo.getGenero());
            alterado.setPreco(cavalo.getPreco());
            alterado.setDisponivelParaCompra(cavalo.isDisponivelParaCompra());
            alterado.setImagem(cavalo.getImagem());
            return cavaloRepository.save(alterado);
        }
        return null;
    }

}





