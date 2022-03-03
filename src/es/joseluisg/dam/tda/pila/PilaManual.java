package es.joseluisg.dam.tda.pila;

import es.joseluisg.dam.tda.lista.ListaEnlazada;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PilaManual<T> extends ListaEnlazada<T> implements IPila<T> {

    @Override
    public void apilar(T dato) {
        this.insertarEnListaInicio(dato);
    }

    @Override
    public T desapilar() {
        if (!vacia()) {
            try {
                T dato = this.getItem(0);
                this.borrarEnListaInicio();
                return dato;
            } catch (Exception ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean esVacia() {
        return false;
    }


    @Override
    public T cima() {
        if (!vacia()) {
            try {
                T dato = this.getItem(0);
                return dato;
            } catch (Exception ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }
}