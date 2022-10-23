import GraphGenerator.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;

import Code.Nodos.Nodo;
import Code.Nodos.NodoCombate;
import Code.Nodos.NodoEvento;
import Code.Nodos.NodoInicial;
import Code.Nodos.NodoJefeFinal;
import Code.Nodos.NodoTienda;

public class JavaQuest {
    public static void main(String[] args) {
        long seed = System.nanoTime();
        Random rand = new Random(seed);

        // Arcos del grafo.
        SortedSet<Edge> edges = GraphGenerator.Generar(2, seed);
        
        // Nodos del grafo.
        ArrayList<Nodo> nodos = new ArrayList<Nodo>();
        


        nodos.add(new NodoInicial(0));
        for (Edge e : edges) {
            if (e.x == nodos.size()){
                Nodo n;
                
                int r = rand.nextInt(100);
                if (r < 30) {
                    n = new NodoEvento(e.x);
                } else if (r < 40) {
                    n = new NodoTienda(e.x);
                } else {
                    n = new NodoCombate(e.x);
                }

                nodos.add(n);
            }
        }
        nodos.add(new NodoJefeFinal(nodos.size()));
        
        for(Edge e : edges){
            nodos.get(e.x).agregarNodo(nodos.get(e.y));
        }


        
        // Muestra cada nodo y sus nodos siguientes.
        for (int i = 0; i < nodos.size(); i++) {
            System.out.println("Nodo " + i + ": " + nodos.get(i).getClass().getSimpleName());
            for (Nodo n : nodos.get(i).getSiguientesNodos()) {
                System.out.println(" - " + n.getId() + ": " + n.getClass().getSimpleName());
            }
        }
    }
}
