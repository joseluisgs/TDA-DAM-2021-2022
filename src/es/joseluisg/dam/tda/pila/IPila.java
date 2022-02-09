package es.joseluisg.dam.tda.pila;

interface IPila<T> {
    void apilar(T item);

    T desapilar();

    boolean esVacia();

    void vaciar();

    int numElem();

    T cima();
}
