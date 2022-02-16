package es.joseluisg.dam.model;

import java.util.Objects;
import java.util.UUID;

public class Droide implements Comparable<Droide> {
    private static int contador = 0;
    int id;
    private String nombre;
    private int año;

    public Droide() {
        this.año = (int) (Math.random() * 100);
        this.nombre = UUID.randomUUID().toString().substring(0, 8);
        this.id = ++contador;
    }

    public Droide(String nombre, int año) {
        this.nombre = nombre;
        this.año = año;
        this.id = ++contador;
    }

    public Droide(int id, String nombre, int año) {
        this.nombre = nombre;
        this.año = año;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Droide{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", año=" + año +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Droide droide = (Droide) o;
        return id == droide.id && año == droide.año && nombre.equals(droide.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, año);
    }

    @Override
    public int compareTo(Droide o) {
        return this.getAño() - o.getAño();
    }
}
