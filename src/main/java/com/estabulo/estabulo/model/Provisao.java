package com.estabulo.estabulo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity (name="Provisao")
public class Provisao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="Id")
    private int id;

    @Column (name="Nome")
    private String nome;

    @Column (name="Tipo") //comida, estimulante, ferramenta ou suplemento
    private String tipo;

    @Column (name="Preço")
    private float preco;

    //definitivamente não sei se
    //mais colunas serão necessáriasKKKKK


    public Provisao() {
    }

    public Provisao(String nome, String tipo, float preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Provisao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                '}';
    }
}
