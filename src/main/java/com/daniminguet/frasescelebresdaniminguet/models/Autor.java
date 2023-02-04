package com.daniminguet.frasescelebresdaniminguet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Autor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = true, length = 128)
    private String nombre;
    @Basic
    @Column(name = "nacimiento", nullable = true)
    private Integer nacimiento;
    @Basic
    @Column(name = "muerte", nullable = true, length = 5)
    private String muerte;
    @Basic
    @Column(name = "profesion", nullable = true, length = 255)
    private String profesion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getMuerte() {
        return muerte;
    }

    public void setMuerte(String muerte) {
        this.muerte = muerte;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return id == autor.id && Objects.equals(nombre, autor.nombre) && Objects.equals(nacimiento, autor.nacimiento) && Objects.equals(muerte, autor.muerte) && Objects.equals(profesion, autor.profesion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, nacimiento, muerte, profesion);
    }
}
