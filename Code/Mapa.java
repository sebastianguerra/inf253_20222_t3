package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import Code.Nodos.*;
import GraphGenerator.Edge;
import GraphGenerator.GraphGenerator;

public class Mapa {
    private Integer profundidad; // Cantidad de "pisos" que tiene el mapa (no incluye el nodo inicial ni el nodo del jefe final).
    private NodoInicial nodo_inicial; // Nodo inicial del mapa.
    private Nodo nodo_actual; // Nodo en el que se encuentra el jugador.


    private Random rand;

    private static final String[][][] conexiones = {
        {{""}, {""}, {""}, {""}},
        {
            {""},
            {"  ║  "},
            {"╔═╩═╗"},
            {"╔═╬═╗"}
        },
        {
            {""},
            {"╚═╦═╝"},
            {"║   ║","╠═╗ ║\n║ ╚═╣", "║ ╔═╣\n╠═╝ ║"},
            {"╠═╗ ║", "║ ╔═╣", "╠═╦╗║\n║ ║╚╣", "║╔╦═╣\n╠╝║ ║", "╠╗ ╔╣\n║╚╦╝║"}
        },
        {
            {""},
            {"╚═╬═╝"},
            {"╠═╝ ║", "║ ╚═╣", "║ ║╔╣\n╠═╩╝║", "╠╗║ ║\n║╚╩═╣", "║╔╩╗║\n╠╝ ╚╣"},
            {"║ ║ ║", "║╔╣ ║\n╠╝║ ║", "║ ║╔╣\n║ ╠╝║", "╠╗║ ║\n║╚╣ ║", "║╔╝╔╣\n╠╝╔╝║", "╠╗╚╗║\n║╚╗╚╣"}
        }
    };

    public Mapa(int profundidad, long seed) {
        SortedSet<Edge> edges = GraphGenerator.Generar(profundidad, seed);

        for(Edge edge : edges) {
            System.out.printf("(%d) -> (%d)\n", edge.x, edge.y);
        }

        rand = new Random(seed);
        this.profundidad = profundidad;
        this.nodo_actual = this.nodo_inicial = new NodoInicial(0);

        ArrayList<Nodo> nodos = new ArrayList<Nodo>();
        nodos.add(this.nodo_inicial);
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

    }



    public void verMapa() {
        SortedSet<Nodo> capa;

        System.out.println("Mapa:");
        List<Nodo> capaActual = new ArrayList<>();
        capaActual.add(this.nodo_actual);

        List<Nodo> capaSiguiente = new ArrayList<>();
        for(Nodo n : this.nodo_actual.getSiguientesNodos()){
            capaSiguiente.add(n);
        }

        while(capaActual.size() > 0){
            int l = capaActual.size();
            if ( l == 1 ) {
                System.out.println("  " + capaActual.get(0).getClass().getSimpleName().charAt(4) + "  ");
            } else if ( l == 2 ) {
                System.out.println(capaActual.get(0).getClass().getSimpleName().charAt(4) + "   " + capaActual.get(1).getClass().getSimpleName().charAt(4));
            } else {
                System.out.println(capaActual.get(0).getClass().getSimpleName().charAt(4) + " " + capaActual.get(1).getClass().getSimpleName().charAt(4) + " " + capaActual.get(2).getClass().getSimpleName().charAt(4));
            }

            // for (Nodo n: capaSiguiente) {
            //     System.out.print(n.getId() + "   ");
            // }System.out.println("");


            System.out.println(
                conexiones
                    [capaActual.size()]
                    [capaSiguiente.size()]
                    [rand.nextInt(
                        conexiones[capaActual.size()][capaSiguiente.size()].length)]);

            capaActual = capaSiguiente;
            capaSiguiente = new ArrayList<>();

            capa = new TreeSet<Nodo>();
            for(Nodo n : capaActual){
                for(Nodo s : n.getSiguientesNodos()){
                    capa.add(s);
                }
            }
            for (Nodo n : capa) {
                capaSiguiente.add(n);
            }
        }

        
    }

    public void avanzar() {
        /* Le muestra al usuario los nodos a los que puede avanzar, le pide seleccionar uno y hace al jugador interactuar con ese nodo. */
        // TODO

        // 1.- Mostrar lista nodos siguientes
        System.out.println("Nodos siguientes:");
        for (Nodo n : nodo_actual.getSiguientesNodos()) {
            System.out.printf("\t(%d) %s\n", n.getId(), n.getClass().getSimpleName());
            System.out.println(n);
        }
        // 2.- Interactuar con nodo elegido y actualizar nodoactual
        


    }
}
