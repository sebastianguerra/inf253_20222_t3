import GraphGenerator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;

import Code.Jugador;
import Code.Nodos.*;

public class JavaQuest {
    static Scanner sc = new Scanner(System.in);
    static int profundidad = 10;
    static long seed = System.nanoTime();
    static Random rand = new Random(seed);

    public static void main(String[] args) {
        // Arcos del grafo.
        SortedSet<Edge> edges = GraphGenerator.Generar(profundidad, seed);

        // Nodos del grafo.
        ArrayList<Nodo> nodos = crearNodos(edges);
        // Muestra cada nodo y sus nodos siguientes.
        for (int i = 0; i < nodos.size(); i++) {
            System.out.println("Nodo " + i + ": " + nodos.get(i).getClass().getSimpleName());
            for (Nodo n : nodos.get(i).getSiguientesNodos()) {
                System.out.println(" - " + n.getId() + ": " + n.getClass().getSimpleName());
            }
        }


        // Solicita un nombre para el jugador y lo crea.
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        Jugador jugador = new Jugador(nombre);


        // Inicia el juego.
        recorrerGrafo(nodos, jugador);
    }
    
    private static void recorrerGrafo(List<Nodo> nodos, Jugador jugador) {
        Nodo nodoActual = nodos.get(0);

        for(int i = 0; i < profundidad+2; i++){
            System.out.println("Nodo " + nodoActual.getId() + ": " + nodoActual.getClass().getSimpleName());
            nodoActual.interactuar(jugador);

            if (i < profundidad+1){
                System.out.println("Nodos disponibles:");
                for (Nodo n : nodoActual.getSiguientesNodos()) {
                    System.out.println(" - " + n.getId() + ": " + n.getClass().getSimpleName());
                }
                System.out.println("Ingrese el id del nodo al cual desea ir: ");
                int id = sc.nextInt();
                nodoActual = nodos.get(id);
            }
        }
    }

    private static ArrayList<Nodo> crearNodos(SortedSet<Edge> edges) {
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
                    n = new NodoCombate(e.x, seed);
                }

                nodos.add(n);
            }
        }
        nodos.add(new NodoJefeFinal(nodos.size()));


        for(Edge e : edges){
            nodos.get(e.x).agregarNodo(nodos.get(e.y));
        }

        return nodos;
    }
}
