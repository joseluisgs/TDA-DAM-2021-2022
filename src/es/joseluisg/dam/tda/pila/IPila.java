package es.joseluisg.dam.tda.pila;

interface IPila<T> {
    void apilar(T item);

    T desapilar();

    boolean esVacia();

    T cima();
}
