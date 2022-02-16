package es.joseluisg.dam.comparators;

import java.util.Comparator;

public class DroideMapKeyDescComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer droide1, Integer droide2) {
        return droide2.compareTo(droide1);
    }

}
