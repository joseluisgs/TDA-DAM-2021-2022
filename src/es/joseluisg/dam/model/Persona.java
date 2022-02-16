package es.joseluisg.dam.model;

import java.util.Objects;
import java.util.UUID;

public class Persona implements Comparable<Persona> {
    private static int contador = 0;
    int edad;
    String nombre;
    int id;

    public Persona() {
        this.edad = (int) (Math.random() * 100);
        this.nombre = UUID.randomUUID().toString().substring(0, 8);
        this.id = ++contador;
    }

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
        this.id = ++contador;
    }

    public Persona(int id, int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && nombre.equals(persona.nombre) && id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(edad, nombre, id);
    }

    @Override
    public int compareTo(Persona o) {
        int res = this.edad - o.edad;
        if (res == 0) {
            res = this.nombre.compareTo(o.nombre);
        }
        return res;
    }
}


