package es.joseluisg.dam;

import es.joseluisg.dam.model.Persona;
import es.joseluisg.dam.tda.cola.Cola;
import es.joseluisg.dam.tda.pila.Pila;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    private static final int TAM = 10;

    public static void main(String[] args) {
        listasPilasColas();
        arraysMultidimensional();
    }


    private static void listasPilasColas() {
        System.out.println("ArrayList");
        ArrayList<Persona> lista = new ArrayList<Persona>();

        for (int i = 0; i < TAM; i++) {
            Persona persona = new Persona();
            lista.add(persona);
        }

        for (Persona persona : lista) {
            System.out.println(persona);

        }

        System.out.println("\nCola");
        Cola<Persona> cola = new Cola<Persona>();

//        cola.encolar(new Persona());
//        cola.encolar(new Persona());
//        cola.encolar(new Persona());
//        cola.encolar(new Persona());
//        cola.encolar(new Persona());

        // Cargamos la cola con la lista para ver el orden...
        for (Persona persona : lista) {
            cola.encolar(persona);
        }
        System.out.println("Soy el primero " + cola.primero());
        System.out.println("Soy el ultimo " + cola.ultimo());

        while (!cola.esVacia()) {
            System.out.println(cola.desencolar());
        }

        System.out.println("\nPila");
        Pila<Persona> pila = new Pila<Persona>();

//        pila.apilar(new Persona());
//        pila.apilar(new Persona());
//        pila.apilar(new Persona());
//        pila.apilar(new Persona());
//        pila.apilar(new Persona());

        // Cargamos la pila con la lista para ver el orden...
        for (Persona persona : lista) {
            pila.apilar(persona);
        }

        System.out.println("Estoy en la cima: " + pila.cima());

        while (!pila.esVacia()) {
            System.out.println(pila.desapilar());
        }

        // Ahora con las clases de JAVA
        System.out.println("\nArrayDeque Queue Cola");
        ArrayDeque<Persona> queue = new ArrayDeque<Persona>();
        // Cargamos la cola con la lista para ver el orden...
        for (Persona persona : lista) {
            queue.add(persona);
        }
        System.out.println("Soy el primero " + queue.peekFirst());
        System.out.println("Soy el ultimo " + queue.peekLast());
        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // RemoveFirst
        }

        System.out.println("\nArrayDeque Stack Pila");
        ArrayDeque<Persona> stack = new ArrayDeque<Persona>();
        // Cargamos la cola con la lista para ver el orden...
        for (Persona persona : lista) {
            stack.push(persona);
        }
        System.out.println("Estoy en la cima: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // RemoveFirst o poll
        }
    }

    private static void arraysMultidimensional() {
        System.out.println("\nArrays Multidimensional");
        // Definimos la matriz. ArrayList de filas, donde cada una es un ArrayList
        ArrayList<ArrayList<Persona>> matrix = new ArrayList<ArrayList<Persona>>();
        // Para cada cosa podemos jugar con un tamaño. Podemos tener columnas de distintos
        // tamaños. y recorrerlas como queramos.
        for (int i = 0; i < TAM; i++) {
            // Creamos cada columna, que es un nuevo arrayList
            ArrayList<Persona> fila = new ArrayList<Persona>();
            for (int j = 0; j < TAM; j++) {
                fila.add(new Persona());
            }
            matrix.add(fila);
        }

        // Mostramos la matriz con dos for anidados
        System.out.println("\nArrays Multidimensional 2 for anidados");
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print("[ " + matrix.get(i).get(j) + " ] ");
            }
            System.out.println();
        }
        // Mostramos la matriz con dos for anidados
        System.out.println("\nArrays Multidimensional 2 foreach");
        for (ArrayList<Persona> personas : matrix) {
            for (Persona persona : personas) {
                System.out.print("[ " + persona + " ] ");
            }
            System.out.println();
        }

        // podemos hacer lista de listas o colas de pilas, o la combinación que queramos
    }
}
