package com.luis.crud.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nome;
    private String ano;
    private String autor;

    public BookEntity(long id, String nome, String ano, String autor) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.autor = autor;
    }

    public BookEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
        
}
