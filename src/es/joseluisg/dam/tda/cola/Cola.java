package es.joseluisg.dam.tda.cola;

import java.util.ArrayList;

public class Cola<T> extends ArrayList<T> implements ICola<T> {

    @Override
    public void encolar(T item) {
        this.add(item);
    }

    @Override
    public T desencolar() {
        return this.remove(0);
    }

    @Override
    public boolean esVacia() {
        return this.isEmpty();
    }

    @Override
    public void vaciar() {
        this.clear();
    }

    @Override
    public int numElem() {
        return this.size();
    }

    @Override
    public T primero() {
        return this.get(0);
    }

    @Override
    public T ultimo() {
        return this.get(this.size() - 1);
    }
}


