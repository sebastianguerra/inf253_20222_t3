import java.util.Random;
import java.util.Scanner;

import Code.Jugador;
import Code.Mapa;

public class JavaQuest {
    static final Scanner sc = new Scanner(System.in);
    static final long seed = System.nanoTime();
    // static final long seed = 17198194107957L;
    static final Random rand = new Random(seed);
    static final int profundidad = 10;

    public static void main(String[] args) {
        System.out.printf("Seed: %d\n", seed);

        final Mapa mapa = new Mapa(profundidad, rand, sc);


        final Jugador jugador = new Jugador(rand);


        // Inicia el juego.
        iniciarJuego(mapa, jugador);
    }
    
    private static void iniciarJuego(Mapa mapa, Jugador jugador) {
        mapa.getNodoActual().interactuar(jugador);
        while(jugador.stillAlive() && !mapa.isFinalNode()) {
            System.out.println("");
            System.out.println("1. Ver mapa: muestra el mapa desde el nodo en el que te encuentras.");
            System.out.println("2. Ver estadisticas: muestra el estado actual de tu personaje.");
            System.out.println("3. Ver inventario: muestra los items que tienes en tu inventario.");
            System.out.println("4. Avanzar: avanza al siguiente o los siguientes nodos.");
            System.out.println("Que deseas hacer?");
            int opcion = sc.nextInt();
            if (opcion == 1) {
                mapa.verMapa();
            } else if (opcion == 2) {
                jugador.verEstado();
            } else if (opcion == 3) {
                jugador.verItems();
            } else if (opcion == 4) {
                mapa.avanzar(jugador);
            } else {
                System.out.println("Opcion invalida");
            }
        }
    }

}
