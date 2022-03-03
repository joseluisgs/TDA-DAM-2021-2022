package es.joseluisg.dam.tda.pila;

import java.util.ArrayList;

public class Pila<T> extends ArrayList<T> implements IPila<T> {

    @Override
    public void apilar(T item) {
        this.add(0, item);
    }

    @Override
    public T desapilar() {
        return this.remove(0);
    }

    @Override
    public boolean esVacia() {
        return this.isEmpty();
    }

    public void vaciar() {
        this.clear();
    }

    public int numElem() {
        return this.size();
    }

    @Override
    public T cima() {
        return this.get(0);
    }
}
