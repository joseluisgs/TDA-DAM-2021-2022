package es.joseluisg.dam.tda.nodos;

/**
 * TDA Nodo genérico
 *
 * @param <T> Tipo de dato a almacenar
 */
public final class Nodo<T> {
    public T dato; // Dato a alamcenar
    public Nodo siguiente; // Puntero a siguiente
    public Nodo anterior; // Para listas doble enlazadas

    /**
     * Costructor por defecto
     */
    public Nodo() {
        this.dato = null;
        this.siguiente = null;
        this.anterior = null;
    }

    /**
     * Costructor parametrizado
     *
     * @param dato Tipo de dato a almacenar
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}