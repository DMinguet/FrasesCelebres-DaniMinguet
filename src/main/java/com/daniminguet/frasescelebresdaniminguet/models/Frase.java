package com.daniminguet.frasescelebresdaniminguet.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Frase {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "texto", nullable = true, length = 300)
    private String texto;
    @Basic
    @Column(name = "fechaprogramada", nullable = true)
    private Date fechaprogramada;
    @Basic
    @Column(name = "autor_id", nullable = false)
    private int autorId;
    @Basic
    @Column(name = "categoria_id", nullable = false)
    private int categoriaId;

    public Frase(String texto, Date fechaprogramada, int autorId, int categoriaId) {
        this.texto = texto;
        this.fechaprogramada = fechaprogramada;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    public Frase() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaprogramada() {
        return fechaprogramada;
    }

    public void setFechaprogramada(Date fechaprogramada) {
        this.fechaprogramada = fechaprogramada;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frase frase = (Frase) o;
        return id == frase.id && autorId == frase.autorId && categoriaId == frase.categoriaId && Objects.equals(texto, frase.texto) && Objects.equals(fechaprogramada, frase.fechaprogramada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, texto, fechaprogramada, autorId, categoriaId);
    }
}
