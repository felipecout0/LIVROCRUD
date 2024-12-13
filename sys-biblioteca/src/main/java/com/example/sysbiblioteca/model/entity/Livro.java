package com.example.sysbiblioteca.model.entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Setter;
@Entity
public class Livro {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String titulo;
    @Setter
    private String autor;
    @Setter
    private Date anoDeLancamento;
    @Setter
    private String genero;

    public Livro( ) {

    }
    public Livro(Long id, String titulo, String autor, Date anoDeLancamento, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoDeLancamento = anoDeLancamento;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public Date getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public String getGenero() {
        return genero;
    }

}