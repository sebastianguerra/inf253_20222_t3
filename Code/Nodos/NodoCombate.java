package Code.Nodos;

import Code.Personaje;

import java.util.Random;
import java.util.Scanner;

import Code.Jugador;

public class NodoCombate extends Nodo {
    private Personaje enemigo; // Enemigo al cual se debe enfrentar el jugador.

    public NodoCombate(int id, Random random, Scanner scanner) {
        super(id, random, scanner);

        int hp = rand.nextInt(10) + 10;
        int danio = rand.nextInt(5) + 1;
        int defensa = rand.nextInt(5) + 1;

        this.enemigo = new Personaje(
            rand,
            "Enemigo", 
            0, 
            hp, 
            hp, 
            danio, 
            defensa
            );
    }

    public void interactuar(Jugador jugador){
        /* Realiza el combate informandole al usuaio los resultados de cada ataque realizado y determina al ganador. */
        jugador.combate(enemigo);
    }
}
