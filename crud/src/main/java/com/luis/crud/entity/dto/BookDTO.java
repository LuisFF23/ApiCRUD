package com.luis.crud.entity.dto;

public class BookDTO {
    
    private String nome;
    private String ano;
    private String autor;
    
    public BookDTO() {
    }
    
    public BookDTO(String nome, String ano, String autor) {
        this.nome = nome;
        this.ano = ano;
        this.autor = autor;
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
