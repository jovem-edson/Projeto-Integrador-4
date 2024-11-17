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
    @Column (name="id") //sim, aqui indica uma coluna :O
    private int id;

    @Column (name="Nome")
    private String nome;

    @Column (name="Idade")
    private int idade;

    @Column (name="Tipo") //Corrida, Tração, Serviço
    private String tipo;

    @Column (name="Raca")
    private String raca;

    @Column (name="Pelagem")
    private String pelagem;

    @Column (name="Genêro")
    private String genero;

    @Column (name="Preço")
    private float preco;

    @Column (name="disponivel para compra")
    private boolean disponivelParaCompra;

    @Column (name="Imagem")
    private String imagem;

    public Cavalo() {
    }

    public Cavalo(String nome, int idade, String tipo, String raca, String pelagem, String genero, float preco, boolean disponivelParaCompra, String imagem) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo.toLowerCase();
        this.raca = raca.toLowerCase();
        this.pelagem = pelagem;
        this.genero = genero;
        this.preco = preco;
        this.disponivelParaCompra = disponivelParaCompra;
        this.imagem = imagem;
    }

    public int getId() {return id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipo() {
        if (tipo == null || tipo.isEmpty()) {
            return tipo;
        }

        return tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.toLowerCase();
    }

    public String getRaca() {
        if (raca == null || raca.isEmpty()) {
            return raca;
        }

        return raca.substring(0, 1).toUpperCase() + raca.substring(1).toLowerCase();
    }

    public void setRaca(String raca) {
        this.raca = raca.toLowerCase();
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public String getGenero() {
        if (genero == null || genero.isEmpty()) {
            return genero;
        }

        return genero.substring(0, 1).toUpperCase() + genero.substring(1).toLowerCase();
    }

    public void setGenero(String genero) {
        this.genero = genero.toLowerCase();
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isDisponivelParaCompra() {
        return disponivelParaCompra;
    }

    public void setDisponivelParaCompra(boolean disponivelParaCompra) {
        this.disponivelParaCompra = disponivelParaCompra;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Cavalo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", tipo='" + tipo + '\'' +
                ", raca='" + raca + '\'' +
                ", pelagem='" + pelagem + '\'' +
                ", genero='" + genero + '\'' +
                ", preco=" + preco + '\'' +
                ", disponivelParaCompra=" + disponivelParaCompra + '\'' +
                ", imagem=" + imagem +
                '}';
    }
}
