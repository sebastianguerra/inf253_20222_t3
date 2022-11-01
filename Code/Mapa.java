package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import Code.Nodos.*;
import GraphGenerator.Edge;
import GraphGenerator.GraphGenerator;

public class Mapa {
    private Integer profundidad;
    private NodoInicial nodo_inicial; // Nodo inicial del mapa.
    private Nodo nodo_actual; // Nodo en el que se encuentra el jugador.
    
    private Integer nNodos;
    private Boolean isInFinalNode = false;


    private Random rand;
    private Scanner sc;

    private static final HashMap <List<Integer>, String> conexiones = new HashMap<List<Integer>, String>();

    public Mapa(int profundidad, Random random, Scanner scanner) {
        this.profundidad = profundidad;
        this.rand = random;
        this.sc = scanner;

        SortedSet<Edge> edges = GraphGenerator.Generar(profundidad, rand);


        this.nodo_actual = this.nodo_inicial = new NodoInicial(0, rand, sc);

        ArrayList<Nodo> nodos = new ArrayList<Nodo>();
        nodos.add(this.nodo_inicial);
        for (Edge e : edges) {
            if (e.x == nodos.size()){
                Nodo n;

                int r = rand.nextInt(100);
                if (r < 30) {
                    n = new NodoEvento(e.x, rand, sc);
                } else if (r < 40) {
                    n = new NodoTienda(e.x, rand, sc);
                } else {
                    n = new NodoCombate(e.x, rand, sc);
                }

                nodos.add(n);
            }
        }
        nodos.add(new NodoJefeFinal(nodos.size(), rand, sc));
        nNodos = nodos.size();


        for(Edge e : edges){
            nodos.get(e.x).agregarNodo(nodos.get(e.y));
        }




        // 1 -> 1
        conexiones.put(Arrays.asList(new Integer[]{1, 1}), "  ║  ");
        // 1 -> 2
        conexiones.put(Arrays.asList(new Integer[]{2, 1, 1}), "╔═╩═╗");
        // 1 -> 3
        conexiones.put(Arrays.asList(new Integer[]{3, 1, 1, 1}), "╔═╬═╗");

        // 2 -> 1
        conexiones.put(Arrays.asList(new Integer[]{1, 1, 2}), "╚═╦═╝");
        // 2 -> 2
        conexiones.put(Arrays.asList(new Integer[]{1, 1, 1, 1}), "║   ║");
        conexiones.put(Arrays.asList(new Integer[]{2, 1, 1, 2}), "╠═╗ ║\n║ ╚═╣");
        conexiones.put(Arrays.asList(new Integer[]{1, 2, 2, 1}), "║ ╔═╣\n╠═╝ ║");
        // 2 -> 3
        conexiones.put(Arrays.asList(new Integer[]{2, 1, 1, 1, 1}), "╠═╗ ║");
        conexiones.put(Arrays.asList(new Integer[]{1, 2, 1, 1, 1}), "║ ╔═╣");
        conexiones.put(Arrays.asList(new Integer[]{3, 1, 1, 1, 2}), "╠═╦╗║\n║ ║╚╣");
        conexiones.put(Arrays.asList(new Integer[]{1, 3, 2, 1, 1}), "║╔╦═╣\n╠╝║ ║");
        conexiones.put(Arrays.asList(new Integer[]{2, 2, 1, 2, 1}), "╠╗ ╔╣\n║╚╦╝║");

        // 3 -> 1
        conexiones.put(Arrays.asList(new Integer[]{1, 1, 1, 3}), "╚═╬═╝");
        // 3 -> 2
        conexiones.put(Arrays.asList(new Integer[]{1, 1, 1, 2, 1}), "╠═╝ ║");
        conexiones.put(Arrays.asList(new Integer[]{1, 1, 1, 1, 2}), "║ ╚═╣");
        conexiones.put(Arrays.asList(new Integer[]{1, 1, 2, 3, 1}), "║ ║╔╣\n╠═╩╝║");
        conexiones.put(Arrays.asList(new Integer[]{2, 1, 1, 1, 3}), "╠╗║ ║\n║╚╩═╣");
        conexiones.put(Arrays.asList(new Integer[]{1, 2, 1, 2, 2}), "║╔╩╗║\n╠╝ ╚╣");
        // 3 -> 3
        conexiones.put(Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1}), "║ ║ ║");
        conexiones.put(Arrays.asList(new Integer[]{1, 2, 1, 2, 1, 1}), "║╔╣ ║\n╠╝║ ║");
        conexiones.put(Arrays.asList(new Integer[]{1, 1, 2, 1, 2, 1}), "║ ║╔╣\n║ ╠╝║");
        conexiones.put(Arrays.asList(new Integer[]{2, 1, 1, 1, 2, 1}), "╠╗║ ║\n║╚╣ ║");
        conexiones.put(Arrays.asList(new Integer[]{1, 2, 1, 1, 1, 2}), "║ ╠╗║\n║ ║╚╣");
        conexiones.put(Arrays.asList(new Integer[]{1, 1, 2, 2, 1, 1}), "║╔╝╔╣\n╠╝╔╝║");
        conexiones.put(Arrays.asList(new Integer[]{2, 1, 1, 1, 1, 2}), "╠╗╚╗║\n║╚╗╚╣");

    }



    public void verMapa() {
        System.out.println("Mapa:");

        SortedSet<Nodo> capa;

        // cantidadConexiones: array que almacena las conexiones de cada nodo en una capa.
        List<Integer> cantidadConexiones = new ArrayList<Integer>(nNodos);
        for(int i = 0; i < nNodos; i++){
            cantidadConexiones.add(0);
        }
        cantidadConexiones.set(this.nodo_actual.getId(), this.nodo_actual.getSiguientesNodos().size());

        List<Nodo> capaActual = new ArrayList<>();
        capaActual.add(this.nodo_actual);

        List<Nodo> capaSiguiente = new ArrayList<>();
        for(Nodo n : this.nodo_actual.getSiguientesNodos()){
            capaSiguiente.add(n);
            cantidadConexiones.set(n.getId(), cantidadConexiones.get(n.getId()) + 1);
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
            if (capaSiguiente.size() == 0) break;


            int actualSize = capaActual.size();
            int siguienteSize = capaSiguiente.size();

            List<Integer> conexionesActuales = new ArrayList<Integer>(actualSize + siguienteSize);
            for(int i = 0; i < actualSize + siguienteSize; i++){
                conexionesActuales.add(0);
            }
            int j = 0;
            for (int i : cantidadConexiones) {
                if (i != 0){
                    conexionesActuales.set(j, i);
                    j++;
                }
            }
            // System.out.println(conexionesActuales);
            String conexion = conexiones.get(conexionesActuales);

            System.out.println(conexion);

            capaActual = capaSiguiente;
            capaSiguiente = new ArrayList<>();
            for(int i = 0; i < nNodos; i++){
                cantidadConexiones.set(i, 0);
            }

            capa = new TreeSet<Nodo>();
            for(Nodo n : capaActual){
                for(Nodo s : n.getSiguientesNodos()){
                    capa.add(s);
                    cantidadConexiones.set(s.getId(), cantidadConexiones.get(s.getId()) + 1);
                    cantidadConexiones.set(n.getId(), cantidadConexiones.get(n.getId()) + 1);
                }
            }
            for (Nodo n : capa) {
                capaSiguiente.add(n);
            }
        }

        
    }

    public void avanzar(Jugador jugador) {
        /* Le muestra al usuario los nodos a los que puede avanzar, le pide seleccionar uno y hace al jugador interactuar con ese nodo. */

        int nSiguientesNodos = nodo_actual.getSiguientesNodos().size();
        if (nSiguientesNodos > 1) {
            System.out.println("Nodos siguientes:");
            int i = 0;
            for (Nodo n : nodo_actual.getSiguientesNodos()) {
                System.out.printf("\t(%d) %s\n", i++, n.getClass().getSimpleName());
            }
            System.out.println("Elige un nodo para avanzar:");
            int eleccion = sc.nextInt();
    
            nodo_actual = nodo_actual.getSiguientesNodos().get(eleccion);
        } else if( nSiguientesNodos == 1 ) {
            nodo_actual = nodo_actual.getSiguientesNodos().get(0);
        }

        if (nodo_actual instanceof NodoJefeFinal) {
            this.isInFinalNode = true;
        }
        nodo_actual.interactuar(jugador);

        


    }

    public Nodo getNodoActual() {
        return nodo_actual;
    }

    public Boolean isFinalNode() {
        return isInFinalNode;
    }
}
