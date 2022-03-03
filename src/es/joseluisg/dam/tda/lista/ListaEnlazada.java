package es.joseluisg.dam.tda.lista;

import es.joseluisg.dam.tda.nodos.Nodo;

public class ListaEnlazada<T> implements ILista<T> {
    protected int tam; // Tamaño
    protected Nodo inicio; // Nodo inicial
    protected Nodo fin; // Nodo final

    /**
     * Costructor por defecto
     */
    public ListaEnlazada() {
        this.tam = 0;
        this.inicio = null;
        this.fin = null;

    }

    /**
     * Inserta en una lista vacía
     *
     * @param dato Dato a insertar
     * @return 0 insertado correctamente
     */
    private int insertarEnListaVacia(T dato) {
        Nodo nuevo = new Nodo(dato);
        this.inicio = nuevo;
        this.fin = nuevo;
        this.tam = 1;
        //System.out.println(dato.toString());
        return 0; // 0 es correcto
    }

    /**
     * Inserta al inicio de una listo
     *
     * @param dato Dato a insertar
     * @return 0 es correcto
     */
    public int insertarEnListaInicio(T dato) {
        if (tam == 0) {
            insertarEnListaVacia(dato);
            return 0;
        } else {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = this.inicio;
            this.inicio = nuevo;
            this.tam++;
            //System.out.println(dato.toString());
            return 0;
        }
    }

    /**
     * Inserta al final de una lista
     *
     * @param dato dato a insertar
     * @return 0 si es correcto
     */
    public int insertarEnListaFinal(T dato) {
        if (tam == 0) {
            insertarEnListaVacia(dato);
            return 0;
        } else {
            // Recorremos hasta el final
            Nodo nuevo = new Nodo(dato);
            Nodo actual = this.inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            this.fin = nuevo;
            this.tam++;
            return 0;
        }
    }

    /**
     * Insterta en una lista en una posición determinada
     *
     * @param dato dato a almacenar
     * @param pos  posición en indice
     * @return 0 correcto
     * @throws java.lang.Exception Indice fuera de rango
     */
    public int insertarEnListaEnIndice(T dato, int pos) throws Exception {
        if (tam == 0) {
            insertarEnListaVacia(dato);
            return 0;
        }
        // Si tiene tamaño 1 e insertamos al comienzo
        else if (tam == 1 && pos == 0) {
            this.insertarEnListaInicio(dato);
            // Si tiene tamaño 1 e insertamos al final
        } else if (tam == 1 && pos == 1) {
            this.insertarEnListaFinal(dato);
            // Si la psoción a insertar es mayor que la del vector, excepcion
        } else if (pos >= tam || pos < 0) {
            throw new Exception("EX: Índice fuera del rango actual de la lista. Posiciones válidas entre 0 y " + this.tam);
        } else {
            Nodo nuevo = new Nodo(dato);
            Nodo actual = this.inicio;
            // navegamos las posiciones
            for (int i = 1; i < pos; i++) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            this.tam++;
            return 0;
        }
        return 0;
    }

    /**
     * Borra en una lista al comienzo
     *
     * @return 0 correcto
     * @throws java.lang.Exception No se puede borrar de la lista vacía
     */
    public int borrarEnListaInicio() throws Exception {
        if (this.tam == 0) {
            throw new Exception("EX: No se puede borrar eb una lista vacía");
        } else {
            if (tam == 1) {
                vaciar();
                return 0;
            } else {
                Nodo sup = this.inicio;
                this.inicio = this.inicio.siguiente; // o sup.siguiente;
                this.tam--;
                return 0;
            }

        }
    }

    /**
     * Vacía completamente una lista
     *
     * @return
     */
    @Override
    public int vaciar() {
        this.fin = null;
        this.inicio = null;
        tam = 0;
        return 0;
    }

    /**
     * Elimina en una posición de la lista
     *
     * @return
     * @throws Exception
     */
    public int borrarEnListaIndice(int pos) throws Exception {
        if (this.tam == 0) {
            throw new Exception("EX: No se puede borrar eb una lista vacía");
        }
        // Si tiene tamaño 1 y vacíamos
        else if (tam == 1 && pos == 0) {
            vaciar();
            return 0;
            // Si tiene tamaño 1 y vaciamos
        } else if (tam == 1 && pos == 1) {
            vaciar();
            return 0;
            // Si la psoción a borrar es mayor que la del vector, excepcion
        } else if (pos >= tam || pos < 0) {
            throw new Exception("EX: Índice fuera del rango actual de la lista. Posiciones válidas entre 0 y " + this.tam);
        } else {
            Nodo actual = this.inicio;
            Nodo sup;
            for (int i = 1; i < pos; i++) {
                actual = actual.siguiente;
            }
            sup = actual.siguiente;
            actual.siguiente = actual.siguiente.siguiente; // o sup.siguiente;
            if (actual.siguiente == null) {
                this.fin = actual;
            }
            this.tam--;
            return 0;
        }
    }

    /**
     * borrar un elemento del final de la lista
     *
     * @return 0
     * @throws java.lang.Exception Lista vacía
     */
    public int borrarEnListaFinal() throws Exception {
        if (this.tam == 0) {
            throw new Exception("EX: No se puede borrar en una lista vacía");
        } else {
            if (tam == 1) {
                vaciar();
                return 0;
            } else {
                borrarEnListaIndice(tam - 1);
                return 0;
            }
        }
    }

    /**
     * Devuelve si la lista está vacía o no;
     *
     * @return
     */
    @Override
    public boolean vacia() {
        return tam == 0;
    }

    /**
     * Imprime una lista
     */
    @Override
    public void imprimir() {
        if (!vacia()) {
            Nodo actual = this.inicio;
            while (actual != null) {
                System.out.println("Elemento->" + actual.dato.toString());
                actual = actual.siguiente;
            }
        } else {
            System.out.println("Lista vacía");
        }
    }

    /**
     * devuelve el tamaño de la lista
     *
     * @return
     */
    @Override
    public int getTamaño() {
        return this.tam;
    }

    public T getItem(int pos) throws Exception {
        if (this.tam == 0) {
            throw new Exception("EX: Lista vacía");
        } else if (pos < 0 || pos >= tam) {
            throw new Exception("EX: Índice fuera del rango actual de la lista. Posiciones válidas entre 0 y " + this.tam);
        } else {
            Nodo actual = this.inicio;
            for (int i = 0; i < pos; i++) {
                actual = actual.siguiente;
            }
            return (T) actual.dato;
        }
    }

}