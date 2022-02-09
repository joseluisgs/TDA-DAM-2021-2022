package es.joseluisg.dam.model;

import java.util.UUID;

public class Persona {
    private static int contador = 0;
    int edad;
    String nombre;
    int id;

    public Persona() {
        this.edad = (int) (Math.random() * 100);
        this.nombre = UUID.randomUUID().toString();
        this.id = ++contador;
    }

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
        this.id = ++contador;
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
}
