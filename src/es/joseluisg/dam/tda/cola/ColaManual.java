package es.joseluisg.dam.tda.cola;

import es.joseluisg.dam.tda.lista.ListaDobleEnlazada;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ColaManual<T> extends ListaDobleEnlazada<T> implements ICola<T> {

    @Override
    public void encolar(T dato) {
        insertarEnListaFinal(dato);
    }

    @Override
    public T desencolar() {
        try {
            T dato = this.getItem(0);
            this.borrarEnListaInicio();
            return dato;
        } catch (Exception ex) {
            Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean esVacia() {
        return false;
    }


    @Override
    public T primero() {
        try {
            return this.getItem(0);
        } catch (Exception ex) {
            Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public T ultimo() {
        try {
            return this.getItem(tam - 1);
        } catch (Exception ex) {
            Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}