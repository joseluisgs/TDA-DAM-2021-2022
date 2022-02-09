package es.joseluisg.dam.tda.cola;

public interface ICola<T> {

    void encolar(T item);

    T desencolar();

    boolean esVacia();

    void vaciar();

    int numElem();

    T primero();

    T ultimo();

}
