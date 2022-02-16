package es.joseluisg.dam.comparators;

import es.joseluisg.dam.model.Droide;

import java.util.Comparator;

public class DroideIdComparator implements Comparator<Droide> {
    @Override
    public int compare(Droide o1, Droide o2) {
        return o1.getId() - o2.getId();
    }
}
