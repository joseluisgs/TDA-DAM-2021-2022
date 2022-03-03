package es.joseluisg.dam.tda.arbol;

import es.joseluisg.dam.tda.nodos.NodoArbol;

public interface IArbolBinario<T> {
    boolean vacio(NodoArbol r);

    boolean esHoja(NodoArbol r);

    int destruir();

    void insertar(T dato);

    void inOrden(NodoArbol nodo, boolean r);

    void preOrden(NodoArbol nodo, boolean r);

    void postOrden(NodoArbol nodo, boolean r);

    int numeroNodos();

    void borrar(T dato);

    boolean buscar(T dato);

    int altura();

    int alturaNodo(T dato);

    T getRaiz();


}