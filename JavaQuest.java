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

        final Mapa mapa = new Mapa(profundidad, rand);
        mapa.verMapa();


        // Solicita un nombre para el jugador y lo crea.
        // System.out.println("Ingresa un nombre: ");
        // final String nombre = sc.nextLine();
        // final Jugador jugador = new Jugador(nombre);


        // Inicia el juego.
        // iniciarJuego(mapa, jugador);
    }
    
    private static void iniciarJuego(Mapa mapa, Jugador jugador) {
        mapa.avanzar();

    }

}
