package com.estabulo.estabulo.repository;

import com.estabulo.estabulo.model.Cavalo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CavaloRepository extends JpaRepository<Cavalo, Integer> {

    @Query("SELECT cavalos FROM Cavalo cavalos WHERE cavalos.nome LIKE LOWER(?1)")
    List<Cavalo> findByNome(String nome);

    @Query("SELECT cavalos FROM Cavalo cavalos WHERE cavalos.disponivelParaCompra=true ORDER BY cavalos.nome")
    List<Cavalo> listarTodosDisponiveisParaCompra();

    @Query("SELECT cavalos FROM Cavalo cavalos WHERE cavalos.disponivelParaCompra=false ORDER BY cavalos.nome")
    List<Cavalo> listarTodosIndisponiveisParaCompra();

    @Query("SELECT cavalos FROM Cavalo cavalos WHERE cavalos.tipo LIKE LOWER(?1) ORDER BY cavalos.tipo")
    List<Cavalo> listarPorTipo(String tipo);

    @Query("SELECT cavalos FROM Cavalo cavalos WHERE cavalos.raca LIKE  LOWER(?1) ORDER BY cavalos.raca")
    List<Cavalo> listarPorRaca(String raca);
}