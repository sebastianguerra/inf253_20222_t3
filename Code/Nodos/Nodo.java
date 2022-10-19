package Code.Nodos;

import Code.Jugador;

public abstract class Nodo {
    private Integer id; // Identificados.
    private Nodo[] siguientes_nodos; // Lista de nodos a los cuales se puede avanzar desde el actual.

    abstract void interactuar(Jugador jugador);

    public void agregarNodo(Nodo nodo){
        /* Agrega un nodo a la lista de siguientes nodos */
        // TODO
    }
}
