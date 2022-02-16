package es.joseluisg.dam;

import es.joseluisg.dam.comparators.DroideIdComparator;
import es.joseluisg.dam.comparators.DroideMapKeyDescComparator;
import es.joseluisg.dam.comparators.PersonaIdComparator;
import es.joseluisg.dam.comparators.PersonaNombreComparator;
import es.joseluisg.dam.model.Droide;
import es.joseluisg.dam.model.Persona;
import es.joseluisg.dam.tda.cola.Cola;
import es.joseluisg.dam.tda.pila.Pila;

import java.util.*;

public class Main {
    private static final int TAM = 10;

    public static void main(String[] args) {
        // Comenta y descomenta para ver el comportamiento de los mapas
        listasPilasColas();
        arraysMultidimensional();
        ordenacionBusqueda();
        cojuntosHashSet();
        conjuntosTreeSet();
        mapasHashMap();
        mapasTreeMap();
    }

    private static void mapasTreeMap() {
        System.out.println("\nTreeMap");
        // Lo ordena por clave, por defecto tiene la ordenación de Integer
        // TreeMap<Integer, Droide> map = new TreeMap<>();
        // Cambiamos el orden a Mayor a menor
        //TreeMap<Integer, Droide> map = new TreeMap<>(Collections.reverseOrder());
        // o
        TreeMap<Integer, Droide> map = new TreeMap<>(new DroideMapKeyDescComparator());

        for (int i = 0; i < TAM; i++) {
            Droide droide = new Droide();
            map.put(droide.getId(), droide);
        }

        Droide d = new Droide(99, "C3PO", 2022);
        map.put(d.getId(), d);
        Droide e = new Droide(99, "C3PO", 2022);
        map.put(e.getId(), e);

        if (map.containsKey(d.getId())) {
            System.out.println(map.get(d.getId()));
        }

        System.out.println(d.equals(e));

        for (Droide droide : map.values()) {
            System.out.println(droide);
        }

        for (Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }

        for (Integer key : map.keySet()) {
            System.out.println("key: " + key + " values : " + map.get(key));
        }
    }

    private static void mapasHashMap() {
        System.out.println("\nHashMap");
        HashMap<Integer, Droide> map = new HashMap<>();

        for (int i = 0; i < TAM; i++) {
            Droide droide = new Droide();
            map.put(droide.getId(), droide);
        }

        Droide d = new Droide(99, "C3PO", 2022);
        map.put(d.getId(), d);
        Droide e = new Droide(99, "C3PO", 2022);
        map.put(e.getId(), e);

        if (map.containsKey(d.getId())) {
            System.out.println(map.get(d.getId()));
        }

        System.out.println(d.equals(e));

        for (Droide droide : map.values()) {
            System.out.println(droide);
        }

        for (Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }

        for (Integer key : map.keySet()) {
            System.out.println("key: " + key + " values : " + map.get(key));
        }
    }

    private static void cojuntosHashSet() {
        System.out.println("\nHashSet");
        HashSet<Droide> set = new HashSet<Droide>();
        for (int i = 0; i < TAM; i++) {
            Droide droide = new Droide();
            set.add(droide);
        }

        Droide d = new Droide(99, "C3PO", 2022);
        set.add(d);
        Droide e = new Droide(99, "C3PO", 2022);
        set.add(e);

        System.out.println(d.equals(e));

        for (Droide droide : set) {
            System.out.println(droide);

        }

    }

    private static void conjuntosTreeSet() {
        System.out.println("\nTreeSet con compareTo");
        TreeSet<Droide> set = new TreeSet<Droide>();
        for (int i = 0; i < TAM; i++) {
            Droide droide = new Droide();
            set.add(droide);
        }

        Droide d = new Droide(99, "C3PO", 2022);
        set.add(d);
        Droide e = new Droide(99, "C3PO", 2022);
        set.add(e);
        Droide f = new Droide(100, "C3PO", -1);
        set.add(f);
        System.out.println(d.equals(e));

        for (Droide droide : set) {
            System.out.println(droide);

        }

        System.out.println("\nTreeSet con Comparator");
        TreeSet<Droide> set2 = new TreeSet<Droide>(new DroideIdComparator());
        for (int i = 0; i < TAM; i++) {
            Droide droide = new Droide();
            set2.add(droide);
        }

        d = new Droide(99, "C3PO", 2022);
        set2.add(d);
        e = new Droide(99, "C3PO", 2022);
        set2.add(e);
        f = new Droide(100, "C3PO", -1);
        set2.add(f);
        System.out.println(d.equals(e));

        for (Droide droide : set2) {
            System.out.println(droide);

        }

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

    private static void ordenacionBusqueda() {
        System.out.println("Ordenación");
        ArrayList<Persona> lista = new ArrayList<Persona>();

        for (int i = 0; i < TAM; i++) {
            Persona persona = new Persona();
            lista.add(persona);
        }

        Persona persona = new Persona(23, "Juan");
        lista.add(persona);
        persona = new Persona(23, "Pepe");
        lista.add(persona);

        System.out.println("Sin ordenar");
        for (Persona p : lista) {
            System.out.println(p);

        }
        Collections.sort(lista);

        System.out.println("Ordenado");
        for (Persona p : lista) {
            System.out.println(p);

        }

        // Comparable
        System.out.println("\nOrdenación Comparator Nombre");
        PersonaNombreComparator comparatorNombre = new PersonaNombreComparator();
        // Collections.sort(lista, comparatorNombre);
        lista.sort(comparatorNombre);
        System.out.println("Ordenado");
        for (Persona p : lista) {
            System.out.println(p);

        }
        System.out.println("\nOrdenación Comparator Id");
        PersonaIdComparator comparatorId = new PersonaIdComparator();
        // Collections.sort(lista, comparatorId);
        lista.sort(comparatorId);
        System.out.println("Ordenado");
        for (Persona p : lista) {
            System.out.println(p);
        }
        lista.sort(new PersonaIdComparator());

        // Busqueda
        System.out.println("\nBusqueda");
        System.out.println("\nContains");
        Persona b = new Persona(11, 23, "Pepe");
        System.out.println("¿Existe?: " + lista.contains(b));
        Persona c = new Persona(12, 23, "Pepe");
        System.out.println("¿Existe?: " + lista.contains(c));

        System.out.println("\nIndexOf");
        System.out.println("¿Existe?: " + lista.indexOf(b));
        System.out.println("¿Existe?: " + lista.indexOf(c));

        System.out.println("\nBinarySearch");
        Collections.sort(lista);
        for (Persona p : lista) {
            System.out.println(p);
        }
        System.out.println("¿Existe?: " + Collections.binarySearch(lista, b));
        System.out.println("¿Existe?: " + Collections.binarySearch(lista, c));

    }
}
