package es.joseluisg.dam.tda.lista;

public interface ILista<T> {
    int getTamaño();

    void imprimir();

    boolean vacia();

    int vaciar();

}