package Code.Nodos;

import java.util.List;
import java.util.ArrayList;

import Code.Jugador;

public abstract class Nodo implements Comparable<Nodo>{
    private Integer id; // Identificados.
    private List<Nodo> siguientes_nodos; // Lista de nodos a los cuales se puede avanzar desde el actual.

    public Nodo(int id) {
        this.id = id;
        this.siguientes_nodos = new ArrayList<Nodo>();
    }

    public abstract void interactuar(Jugador jugador);

    public void agregarNodo(Nodo nodo){
        siguientes_nodos.add(nodo);
    }

    public List<Nodo> getSiguientesNodos(){
        return siguientes_nodos;
    }

    public Integer getId(){
        return id;
    }

    public int compareTo(Nodo e) {
        return this.id.compareTo(e.id);
    }
}
