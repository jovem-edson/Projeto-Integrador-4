package com.estabulo.estabulo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity (name="Usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column (name="Id")
    private int id;

    @OneToMany(mappedBy = "usuario") //um usuario poder ter vários cavalos
    private List<Cavalos> cavalos; //lista de cavalos que o usuario tem

    @Column (name="Nome")
    private String nome;

    @Column (name="CPF")
    private String cpf;

    @Column (name="Telefone")
    private String telefone;

    @Column (name="Email")
    private String email;
}
