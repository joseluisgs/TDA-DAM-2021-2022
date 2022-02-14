package es.joseluisg.dam.comparators;

import es.joseluisg.dam.model.Persona;

import java.util.Comparator;

public class PersonaNombreComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
