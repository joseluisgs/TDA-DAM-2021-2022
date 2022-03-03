package es.joseluisg.dam.tda.arbol;

import es.joseluisg.dam.tda.cola.Cola;
import es.joseluisg.dam.tda.cola.ICola;
import es.joseluisg.dam.tda.nodos.NodoArbol;

public class ArbolBinario<T> implements IArbolBinario<T>, IArbolEquilibrado<T> {
    protected NodoArbol raiz;
    protected NodoArbol actual;
    protected int contador;
    protected int altura;


    /**
     * Costructor por defecto
     */
    public ArbolBinario() {
        raiz = null;
        actual = null;
        contador = 0;
        altura = 0;
    }


    /**
     * Devuelve si un nodo está vacio, sin descendientes
     *
     * @param r nodo
     * @return
     */
    @Override
    public boolean vacio(NodoArbol r) {
        return r == null;
    }

    /**
     * devuelve si un nodo es hoja
     *
     * @param r
     * @return
     */
    @Override
    public boolean esHoja(NodoArbol r) {
        return r.izquierdo == null && r.derecho != null;
    }

    /**
     * Devuelve el valor actual
     *
     * @return
     */
    public T valorActual() {
        return (T) actual.dato;
    }

    @Override
    public T getRaiz() {
        return (T) raiz.dato;
    }

    /**
     * situa actual como raiz, es decir lo vuelve a apuntar
     *
     * @return
     */
    public void raiz() {
        actual = raiz;
    }


    /**
     * Podamos un nodo
     *
     * @param n
     */
    private void podar(NodoArbol n) {
        // algoritmo recursivo, recorrido en post-orden
        if (n != null) {
            podar(n.izquierdo);
            podar(n.derecho);
            n = null;
        }
    }

    /**
     * Destructor del arbol
     *
     * @return 0 correcto
     */
    @Override
    public int destruir() {
        podar(raiz);
        return 0;
    }

    private void inicializar() {
        raiz = null;
        actual = null;
        contador = 0;
        altura = 0;
    }

    /**
     * Inserta un dato en el arbol
     *
     * @param dato
     */
    /*
    @Override
    public void insertar(T dato) {
        NodoArbol padre = null;
        actual = raiz;
        // Buscar el dato en el árbol, manteniendo un puntero al nodo padre
        while(!vacio(actual) && !dato.equals(actual.dato)) {
            padre = actual;
            // Si el dato es mayor que el dato del nodo actual nos vamos por la derecha
           if (((Comparable)dato).compareTo((Comparable)actual.dato)>0)
               //if(dato > actual.dato)
               actual = actual.derecho;
           // si no nos vamos por la izquierda
           else if (((Comparable)dato).compareTo((Comparable)actual.dato)<0)
               //else if(dato < actual.dato)
                actual = actual.izquierdo;
        }
        // Si se ha encontrado el elemento, regresar sin insertar
        if(!vacio(actual)) return;
        // Si padre es NULL, entonces el árbol estaba vacío, el nuevo nodo será
        // el nodo raiz
        if(vacio(padre)) raiz = new NodoArbol(dato);
        // Si el dato es menor que el que contiene el nodo padre, lo insertamos
        // en la rama izquierda
        else if (((Comparable)dato).compareTo((Comparable)padre.dato)<0)
            padre.izquierdo = new NodoArbol(dato);
        // Si el dato es mayor que el que contiene el nodo padre, lo insertamos
        // en la rama derecha
        else if (((Comparable)dato).compareTo((Comparable)padre.dato)>0)
            padre.derecho = new NodoArbol(dato);
    }
    /**
     * Inserta nodos de manera recursiva
     * @param dato
     */
    @Override
    public void insertar(T dato) {
        this.raiz = insertarRec(raiz, dato);
    }

    /**
     * Inserta un dato de manera recursiva
     *
     * @param raiz nodo raiz en ese momento del subarbol
     * @param dato dato a insertar
     * @return devuelve el subarbol insertado
     */
    private NodoArbol insertarRec(NodoArbol raiz, T dato) {

        //Si el arbol está vacío lo insertamos
        if (raiz == null) {
            raiz = new NodoArbol(dato);
            return raiz;
        }

        // en otro caso, navegamos por el arbol hasta insertarlo
        if (((Comparable) dato).compareTo(raiz.dato) < 0)
            raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
        else if (((Comparable) dato).compareTo(raiz.dato) > 0)
            raiz.derecho = insertarRec(raiz.derecho, dato);

        //devolvemos el subarbol creado
        return raiz;
    }

    /**
     * Recorrido en inOrden
     * subArbol izquierdo
     * Dato
     * subArbol derecho
     *
     * @param nodo Nodo para comenzar
     * @param r    Si es raiz
     */
    @Override
    public void inOrden(NodoArbol nodo, boolean r) {
        if (r)
            nodo = raiz;

        //Recorremos sub-arbol izquierdo
        if (nodo.izquierdo != null)
            inOrden(nodo.izquierdo, false);
        //imprimimos el dato
        System.out.print(nodo.dato.toString() + ",");
        //Recorremos sub-arbol derecho
        if (nodo.derecho != null)
            inOrden(nodo.derecho, false);
    }

    /**
     * Recorrido en preOrden
     * Dato
     * subArbol izquierdo
     * subArbol derecho
     *
     * @param nodo Nodo para comenzar
     * @param r    Si es raiz
     */
    @Override
    public void preOrden(NodoArbol nodo, boolean r) {
        if (r)
            nodo = raiz;

        //imprimimos el dato
        System.out.print(nodo.dato.toString() + ",");
        //Recorremos sub-arbol izquierdo
        if (nodo.izquierdo != null)
            preOrden(nodo.izquierdo, false);
        //Recorremos sub-arbol derecho
        if (nodo.derecho != null)
            preOrden(nodo.derecho, false);
    }

    /**
     * Recorrido en postOrden
     * subArbol izquierdo
     * subArbol derecho
     * Dato
     *
     * @param nodo Nodo para comenzar
     * @param r    Si es raiz
     */
    @Override
    public void postOrden(NodoArbol nodo, boolean r) {
        if (r)
            nodo = raiz;

        //Recorremos sub-arbol izquierdo
        if (nodo.izquierdo != null)
            preOrden(nodo.izquierdo, false);
        //Recorremos sub-arbol derecho
        if (nodo.derecho != null)
            preOrden(nodo.derecho, false);
        //imprimimos el dato
        System.out.print(nodo.dato.toString() + ",");
    }
    /**
     * Borra un nodo de un arbol de manera no recursiva
     * @param dato Dato a borrar
     */
    /*
    @Override
    public void borrar(T dato){
        NodoArbol padre = null;
        NodoArbol nodo = null;
        T aux = dato; // lo almaceno tempralmente
        actual = raiz; // Situamos el puntero a la razi y a recorrer
        // Mientras sea posible que el valor esté en el árbol
        while(!vacio(actual)) {
            if(dato.equals(actual.dato)) { // Si el valor está en el nodo actual
                if(esHoja(actual)) { // Y si además es un nodo hoja: lo borramos
                    if(padre!=null) // Si tiene padre (no es el nodo raiz)
                   // Anulamos el puntero que le hace referencia ya sea por el lado izquierdo o derecho
                   if(padre.derecho.equals(actual))
                       padre.derecho = null;
                   else if(padre.izquierdo.equals(actual))
                       padre.izquierdo = null;
                actual = null;
                return;
                }else{ // Si el valor está en el nodo actual, pero no es hoja
                    // Buscar nodo
                    padre = actual;
                    // Buscar nodo más izquierdo de rama derecha
                    if(actual.derecho!=null) {
                        nodo = actual.derecho;
                        while(nodo.izquierdo!=null) {
                            padre = nodo;
                            nodo = nodo.izquierdo;
                        }
                    }
                    // O buscar nodo más derecho de rama izquierda
                    else if(actual.izquierdo!=null){
                        nodo = actual.izquierdo;
                        while(nodo.derecho!=null) {
                            padre = nodo;
                            nodo = nodo.derecho;
                        }
                    }
                    // Intercambiar valores de nodo a borrar u nodo encontrado
                    // y continuar, cerrando el bucle. El nodo encontrado no tiene
                    // por ser un nodo hoja, cerrando el bucle nos aseguramos
                    // de que sólo se eliminan nodos hoja.
                    aux = (T)actual.dato;
                    actual.dato = nodo.dato;
                    nodo.dato = aux;
                    actual = nodo;
                }
            }
            else { // Todavía no hemos encontrado el valor, seguir buscándolo
                padre = actual;
                // si es mayor el dato que el nodo actual, nos vamos por la derecha
                if(((Comparable)dato).compareTo((Comparable)actual.dato)>0)
                    actual = actual.derecho;
                // si no, por la izquierda
                else if(((Comparable)dato).compareTo((Comparable)actual.dato)<0)
                    actual = actual.izquierdo;
            }
        }
    }
    */

    /**
     * Borrar un nodo de un arbol de manera recursiva en base a su valor
     *
     * @param dato Dato a borrar
     */
    @Override
    public void borrar(T dato) {
        raiz = borrarRec(raiz, dato);
    }

    /**
     * Borrar un nodo recursivamente y devuelve el subarbol
     *
     * @param raiz nodo raiz del sub arbol
     * @param dato dato a borrar
     * @return nuevo sub arbol
     */
    private NodoArbol borrarRec(NodoArbol raiz, T dato) {
        // Si el arbol está vacío
        if (raiz == null)
            return raiz;
        // en otro caso, segun el valor borramos por la parte que nos toque
        if (((Comparable) dato).compareTo(raiz.dato) < 0)
            raiz.izquierdo = borrarRec(raiz.izquierdo, dato);
        else if (((Comparable) dato).compareTo(raiz.dato) > 0)
            raiz.derecho = borrarRec(raiz.derecho, dato);

            // Si el dato, es el mismo que la raz aztual, este es nuestro nodo a borrar
        else {
            // nodo con un solo hijo o sin hijos, devolvemos el que nos queda
            if (raiz.izquierdo == null)
                return raiz.derecho;
            else if (raiz.derecho == null)
                return raiz.izquierdo;

            // Nodo con dos hijos:  obtenemos en inorden ek suceso, es decir el más pequeño  en el sub arbol derecho
            raiz.dato = valorMinimo(raiz.derecho);

            // Borramos en inorden el sucesor
            raiz.derecho = borrarRec(raiz.derecho, (T) raiz.dato);
        }

        return raiz;
    }

    /**
     * Obtiene el valor mínimo de un arbol
     *
     * @param raiz nodo raiz del sub arbol
     * @return
     */
    private T valorMinimo(NodoArbol raiz) {
        T minv = (T) raiz.dato;
        while (raiz.izquierdo != null) {
            minv = (T) raiz.izquierdo.dato;
            raiz = raiz.izquierdo;
        }
        return minv;
    }

    /**
     * Calcula el número de nodos de un arbol
     *
     * @return número de nodos
     */
    @Override
    public int numeroNodos() {
        this.contador = 0;
        numeroNodosRec(raiz); // FUnción auxiliar
        return contador;
    }

    /**
     * Función auxiliar para contar nodos. Función recursiva de recorrido en
     * preorden, el proceso es aumentar el contador
     *
     * @param nodo
     */
    private void numeroNodosRec(NodoArbol nodo) {
        contador++;  // Otro nodo
        // Continuar recorrido
        if (nodo.izquierdo != null)
            numeroNodosRec(nodo.izquierdo);
        if (nodo.derecho != null)
            numeroNodosRec(nodo.derecho);
    }

    /**
     * Busca un nodo recursivamente
     *
     * @param dato dato a buscar
     * @return verdadero si existe
     */
    @Override
    public boolean buscar(T dato) {
        NodoArbol aux = null;
        aux = buscarRec(raiz, dato);
        // redundante, se puede resolver sin comprar el dato
        return aux != null && aux.dato.equals(dato);
    }

    /**
     * Busca un nodo de maera recursova en el sub arbol adecuado
     *
     * @param raiz nodo raiz del sub arbol
     * @param dato a buscar
     * @return
     */
    private NodoArbol buscarRec(NodoArbol raiz, T dato) {
        // Caso base, el arbol no tiene nodos, o el dato está en la raiz
        if (raiz == null || raiz.dato.equals(dato))
            return raiz;

        // Si el valor del dato es menor que a raiz, busqueda por el sub arbol izquierdo
        if (((Comparable) dato).compareTo(raiz.dato) < 0)
            return buscarRec(raiz.izquierdo, dato);

        // si es mayor, buscamos por el sub arbol derecho
        if (((Comparable) dato).compareTo(raiz.dato) > 0)
            return buscarRec(raiz.derecho, dato);
        return null;
    }

    /**
     * Devuleve la altura de un arbol
     *
     * @return altura del alrbol
     */
    @Override
    public int altura() {
        this.altura = 0;
        int a = 0;
        alturaRec(raiz, a); // Función auxiliar
        return altura;
    }

    /**
     * Calcula la altura de un sub arbol
     *
     * @param nodo del sub arbol
     * @param a    altura del sub arbol
     */
    private void alturaRec(NodoArbol nodo, int a) {
        // Recorrido postorden
        if (nodo.izquierdo != null) {
            a++;
            alturaRec(nodo.izquierdo, a);
        }
        if (nodo.derecho != null) {
            a++;
            alturaRec(nodo.derecho, a);
        }
        // Proceso, si es un nodo hoja, y su altura es mayor que la actual del
        // árbol, actualizamos la altura actual del árbol
        if (esHoja(nodo) && a > altura)
            altura = a;
    }


    /**
     * Devuleve la altura de un nodo determinado
     *
     * @param dato dato a buscar la altura
     * @return altura
     */
    @Override
    public int alturaNodo(T dato) {
        //return alturaNodoRec(raiz, dato, 1);
        // sin recursividad
        altura = 0;
        actual = raiz;

        // Todavía puede aparecer, ya que quedan nodos por mirar
        while (!vacio(actual)) {
            if (dato.equals(actual.dato))
                return altura; // encontrado
            else {
                altura++; // Incrementamos la altura, seguimos buscando por los sub arbol
                if (((Comparable) dato).compareTo(actual.dato) > 0)
                    actual = actual.derecho;
                else if (((Comparable) dato).compareTo(raiz.dato) < 0)
                    actual = actual.izquierdo;
            }
        }
        return -1; // No está en árbol
    }


    /**
     * Crear una lista (cola o pila) mediante la lectura en inorden del árbol
     * volver a reconstruirlo equilibrado.
     * Conociendo el número de elementos no es demasiado complicado.
     * PERO ES COSTOSO Y SE DEBE HACER CON CUIDADO
     */
    @Override
    public void equilibrar() {
        Cola<T> cola = new Cola<T>();
        meterListaInOrden(null, true, cola);
        // Obtenemos el valor de la mitad
        //int mitad = cola.tam/2;
        int tam = cola.size();

        // inciializamos el arbol
        this.inicializar();

        // Equlibramos recursivo
        this.raiz = equilibrarRec(cola, 0, tam - 1);





        /*

        try {
            // inciializamos el arbol
            this.inicializar();
            //insertamos la nueva raiz, que es la mitad
            this.insertar(cola.getItem(mitad));
            // ahora recorremos la lista e insertamos el resto
            while(!cola.vacia()){
                this.insertar(cola.desencolar()); // ojo estamos metiendo dos veces el nodo mitad, pero ya está controlado
            }


        } catch (Exception ex) {
            Logger.getLogger(ArbolBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }

    /**
     * Encolamos el arbol el in orde, para que esté ordenado
     *
     * @param nodo Nodo a meter del sun arbol
     * @param r    si está encolado
     * @param cola la cola donde se mte
     */
    private void meterListaInOrden(NodoArbol nodo, boolean r, ICola<T> cola) {
        if (r)
            nodo = raiz;

        //Recorremos sub-arbol izquierdo
        if (nodo.izquierdo != null)
            meterListaInOrden(nodo.izquierdo, false, cola);
        //imprimimos el dato
        cola.encolar((T) nodo.dato);
        //System.out.print(nodo.dato.toString()+",");
        //Recorremos sub-arbol derecho
        if (nodo.derecho != null)
            meterListaInOrden(nodo.derecho, false, cola);
    }

    private NodoArbol equilibrarRec(Cola<T> cola, int ini, int fin) {
        //Si el arbol está vacío lo insertamos
        if (ini > fin)
            return null;
        else {
            int mid = (ini + fin) / 2;
            NodoArbol izq = equilibrarRec(cola, ini, mid - 1);
            T dato = cola.desencolar(); // desconcalomos y sacamos de la lista
            NodoArbol ra = new NodoArbol();
            ra.dato = dato;
            NodoArbol der = equilibrarRec(cola, mid + 1, fin);
            ra.izquierdo = izq;
            ra.derecho = der;
            return ra;
        }

    }


}// Fin de clase