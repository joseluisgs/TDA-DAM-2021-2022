package es.joseluisg.dam.tda.nodos;

public final class NodoArbol<T> {
    public T dato; // Dato a alamcenar
    public NodoArbol izquierdo; // Puntero a siguiente
    public NodoArbol derecho; // Para listas doble enlazadas

    /**
     * Costructor por defecto
     */
    public NodoArbol() {
        this.dato = null;
        this.izquierdo = null;
        this.derecho = null;
    }

    /**
     * Costructor parametrizado
     *
     * @param dato Tipo de dato a almacenar
     */
    public NodoArbol(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}