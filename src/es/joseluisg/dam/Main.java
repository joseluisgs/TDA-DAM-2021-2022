package es.joseluisg.dam;

import es.joseluisg.dam.comparators.DroideIdComparator;
import es.joseluisg.dam.comparators.DroideMapKeyDescComparator;
import es.joseluisg.dam.comparators.PersonaIdComparator;
import es.joseluisg.dam.comparators.PersonaNombreComparator;
import es.joseluisg.dam.model.Droide;
import es.joseluisg.dam.model.Persona;
import es.joseluisg.dam.tda.arbol.ArbolBinario;
import es.joseluisg.dam.tda.cola.Cola;
import es.joseluisg.dam.tda.cola.ColaManual;
import es.joseluisg.dam.tda.lista.ListaDobleEnlazada;
import es.joseluisg.dam.tda.lista.ListaEnlazada;
import es.joseluisg.dam.tda.pila.Pila;
import es.joseluisg.dam.tda.pila.PilaManual;

import java.util.*;

public class Main {
    private static final int TAM = 10;

    public static void main(String[] args) throws Exception {
        // Comenta y descomenta para ver el comportamiento de los mapas
        listasPilasColas();
        arraysMultidimensional();
        ordenacionBusqueda();
        cojuntosHashSet();
        conjuntosTreeSet();
        mapasHashMap();
        mapasTreeMap();

        // Mis propios TDAS implementados a mano
        TestListaEnlazada();
        //TestListaDobleEnlazada();
        //TestPila();
        //TestCola();
        //TestArbolBinario();
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

    private static void TestListaEnlazada() throws Exception {
        // TODO code application logic here

        // Probando lista enlazada
        ListaEnlazada<String> le = new ListaEnlazada();

        // insetramos tres datos al comienzo, el ultimo será el primero al imprimir
        System.out.println("Insertar al principio");
        for (int i = 1; i <= 3; i++) {
            le.insertarEnListaInicio("Dato " + i);
        }
        le.imprimir();
        System.out.println();

        // insetramos tres datos al final, el ultimo será el último
        System.out.println("Insertar al Final");
        for (int i = 7; i <= 9; i++) {
            le.insertarEnListaFinal("Dato " + i);
        }
        le.imprimir();
        System.out.println();


        // insertamos en varias posiciones, dos de ellas erroneas
        System.out.println("Insertar en una posición");
        //le.insertarEnListaEnIndice("Dato -1", -1);
        //le.insertarEnListaEnIndice("Dato 99", 99);
        le.insertarEnListaEnIndice("Dato 55", 5);
        le.imprimir();
        System.out.println();

        // Borramos al comienzo
        System.out.println("Borrar al inicio");
        le.borrarEnListaInicio();
        le.imprimir();
        System.out.println();

        // Borramos al final
        System.out.println("Borrar al final");
        le.borrarEnListaFinal();
        le.imprimir();
        System.out.println();

        // Borramos en medio
        System.out.println("Borrar en medio");
        le.borrarEnListaIndice(2);
        le.imprimir();
        System.out.println();

        //obtenemos distintos elementos
        System.out.println(le.getItem(0));
        System.out.println(le.getItem(2));
        System.out.println(le.getItem(le.getTamaño() - 1));
        //System.out.println(le.getItem(34).toString());
    }

    private static void TestListaDobleEnlazada() throws Exception {
        // TODO code application logic here

        // Probando lista enlazada
        ListaDobleEnlazada<String> ld = new ListaDobleEnlazada();

        // insetramos tres datos al comienzo, el ultimo será el primero al imprimir
        System.out.println("Insertar al principio");
        for (int i = 1; i <= 3; i++) {
            ld.insertarEnListaInicio("Dato " + i);
        }
        ld.imprimir();
        System.out.println();

        // insetramos tres datos al final, el ultimo será el último
        System.out.println("Insertar al Final");
        for (int i = 7; i <= 9; i++) {
            ld.insertarEnListaFinal("Dato " + i);
        }
        ld.imprimir();
        System.out.println();


        // insertamos en varias posiciones, dos de ellas erroneas
        System.out.println("Insertar en una posición");
        //le.insertarEnListaEnIndice("Dato -1", -1);
        //le.insertarEnListaEnIndice("Dato 99", 99);
        ld.insertarEnListaEnIndice("Dato 55", 5);
        ld.imprimir();
        System.out.println();


        // Borramos al comienzo
        System.out.println("Borrar al inicio");
        ld.borrarEnListaInicio();
        ld.imprimir();
        System.out.println();


        // Borramos al final
        System.out.println("Borrar al final");
        ld.borrarEnListaFinal();
        ld.imprimir();
        System.out.println();


        // Borramos en medio
        System.out.println("Borrar en medio");
        ld.borrarEnListaIndice(2);
        ld.imprimir();
        System.out.println();


        //obtenemos distintos elementos
        System.out.println(ld.getItem(0).toString());
        System.out.println(ld.getItem(2).toString());
        System.out.println(ld.getItem(ld.getTamaño() - 1).toString());
        //System.out.println(le.getItem(34).toString());
        System.out.println();

        //imprimimos
        System.out.println("Imprimimos del principio al final");
        ld.imprimir();
        System.out.println();
        System.out.println("Imprimimos del final al principio");
        ld.impirmirReverso();
        System.out.println();

    }

    private static void TestPila() {
        PilaManual<String> p = new PilaManual();

        // insetramos tres datos al comienzo, el ultimo será el primero al imprimir
        System.out.println("Apilar");
        for (int i = 1; i <= 3; i++) {
            p.apilar("Dato " + i);
        }
        p.imprimir();
        System.out.println();

        System.out.println("Tope");
        System.out.println(p.cima());

        System.out.println("Desapilamos");
        System.out.println(p.desapilar());

        System.out.println("Imprimimos");
        p.imprimir();
        System.out.println();

        System.out.println("Desapilamos todo");
        while (!p.vacia()) {
            System.out.println("Sale -> " + p.desapilar());
        }
    }

    private static void TestCola() {
        ColaManual<String> c = new ColaManual();

        // insetramos al final en una cola, el ultimo será el último
        System.out.println("Encolar");
        for (int i = 1; i <= 3; i++) {
            c.encolar("Dato " + i);
        }
        c.imprimir();
        System.out.println();

        System.out.println("Primero");
        System.out.println(c.primero());
        System.out.println("Ultimo");
        System.out.println(c.ultimo());

        System.out.println("Desencolamos");
        System.out.println(c.desencolar());

        System.out.println("Imprimimos");
        c.imprimir();
        System.out.println();

        System.out.println("Desencolamos todo");
        while (!c.vacia()) {
            System.out.println("Sale -> " + c.desencolar());
        }


    }

    private static void TestArbolBinario() {
        ArbolBinario<Integer> a = new ArbolBinario<Integer>();
        // Inserción de nodos en árbol:
        a.insertar(19);
        a.insertar(5);
        a.insertar(12);
        a.insertar(4);
        a.insertar(7);
        a.insertar(3);
        a.insertar(6);
        a.insertar(9);
        a.insertar(8);
        a.insertar(11);
        a.insertar(14);
        a.insertar(13);
        a.insertar(2);
        a.insertar(1);
        a.insertar(15);
        a.insertar(10);
        a.insertar(17);
        a.insertar(18);
        a.insertar(16);

        System.out.println("Probando Recorridos");
        System.out.println("Recorrido en inOrden");
        a.inOrden(null, true);
        System.out.println();
        System.out.println("Recorrido en preOrden");
        a.preOrden(null, true);
        System.out.println();
        System.out.println("Recorrido en postOrden");
        a.postOrden(null, true);
        System.out.println();

        // Buscamos algúnos nodos
        System.out.println();
        if (a.buscar(12))
            System.out.println("El 12 SI está en el arbol");
        else
            System.out.println("El 12 NO está en el arbol");

        if (a.buscar(99))
            System.out.println("El 99 SI está en el arbol");
        else
            System.out.println("El 99 NO está en el arbol");

        // Borraremos algunos elementos:
        System.out.println();
        System.out.println("Nº Nodos: " + a.numeroNodos());
        System.out.println("Borramos el 5");
        a.borrar(5);
        System.out.println("Nº Nodos: " + a.numeroNodos());
        a.inOrden(null, true);
        System.out.println();
        System.out.println("Borramos el 8");
        a.borrar(8);
        System.out.println("Nº Nodos: " + a.numeroNodos());
        a.inOrden(null, true);
        System.out.println();
        System.out.println("Borramos el 245"); // No está
        a.borrar(245);
        System.out.println("Nº Nodos: " + a.numeroNodos());
        a.inOrden(null, true);
        System.out.println();

        System.out.println("Borramos el 10"); // Es la raiz
        a.borrar(10);
        System.out.println("Nº Nodos: " + a.numeroNodos());
        a.inOrden(null, true);
        System.out.println();


        // Otras funciones
        System.out.println();
        System.out.println("Nº Nodos: " + a.numeroNodos());
        System.out.println("Raiz del Arbol: " + a.getRaiz().toString());
        System.out.println("Altura del arbol: " + a.altura());
        System.out.println("altura de 1: " + a.alturaNodo(1));
        System.out.println("altura de 10: " + a.alturaNodo(10)); // No está
        System.out.println("altura de 18: " + a.alturaNodo(18));


        //Equilibramos o balanceamos
        System.out.println();
        System.out.println("Equilibramos el arbol");
        a.equilibrar();
        System.out.println("Nº Nodos: " + a.numeroNodos());
        System.out.println("Raiz del Arbol: " + a.getRaiz().toString());
        System.out.println("arbol en pre-orden");
        a.preOrden(null, true);
        System.out.println();
        System.out.println("arbol en in-orden");
        a.inOrden(null, true);
        System.out.println();
        System.out.println();


    }
}
