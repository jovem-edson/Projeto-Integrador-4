package com.estabulo.estabulo.model;

import jakarta.persistence.*;
//a biblioteca jakarta é utilizada para mapear classes Java
//para tabelas em um banco de dados relacional.

import java.io.Serializable;
//Isso importa a interface Serializable, que é usada para
// indicar que a classe pode ser serializada
//(transformada em um formato que pode ser facilmente
// armazenado ou transmitido).

@Entity (name="Cavalo") // representa uma tabela no banco de dados.
public class Cavalo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id //informa que este atributo será a PK da tabela
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Essa anotação informa ao JPA que o valor do campo id deve ser gerado e incrementado automaticamente.
    @Column (name="RA") //sim, aqui indica uma coluna :O
    private int id;

    @ManyToOne
    @JoinColumn(name="usuario_id") //coluna para armazenar o id do usuario
    private Usuario usuario;

    @Column (name="Nome")
    private String nome;

    @Column (name="Tipo")
    private String tipo;

    @Column (name="Raça")
    private String raca;

    @Column (name="Pelagem")
    private String pelagem;

    @Column (name="Genêro")
    private String genero;

    @Column (name="Preço")
    private float preco;

    @Column (name="Disponibilidade")
    private boolean disponibilidade;

    public Cavalo() {
    }

    public Cavalo(String nome, String tipo, String raca, String pelagem, String genero, float preco, boolean disponibilidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.pelagem = pelagem;
        this.genero = genero;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Cavalo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", raca='" + raca + '\'' +
                ", pelagem='" + pelagem + '\'' +
                ", genero='" + genero + '\'' +
                ", preco=" + preco +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
