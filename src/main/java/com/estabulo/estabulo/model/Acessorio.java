package com.estabulo.estabulo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity (name="Acessorio")
public class Acessorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="Id")
    private int id;

    @Column (name="Nome")
    private String nome;

    @Column (name="Tipo")
    private String tipo;

    @Column (name="Descrição")
    private String descricao;

    @Column (name="Preco")
    private float preco;

    //mais colunas?

    public Acessorio() {}

    public Acessorio(String nome, String tipo, String descricao, float preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {return id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Acessorio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
