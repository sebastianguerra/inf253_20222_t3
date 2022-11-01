package Code.Nodos;

import Code.Personaje;

import java.util.Random;
import java.util.Scanner;

import Code.Jugador;

public class NodoJefeFinal extends Nodo {
    private Personaje jefe; // Enemigo al cual se debe enfrentar el jugador.

    public NodoJefeFinal(int id, Random random, Scanner scanner) {
        super(id, random, scanner);
    }

    public void interactuar(Jugador jugador){
        /* Realiza el combate informandole al usuaio los resultados de cada ataque realizado y determina al ganador. */
        jugador.combate(jefe);
    }
}
