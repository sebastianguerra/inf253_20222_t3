package Code.Nodos;

import java.util.Random;
import java.util.Scanner;

import Code.Jugador;

public class NodoInicial extends Nodo {
    public NodoInicial(int id, Random random, Scanner scanner) {
        super(id, random, scanner);
    }

    public void interactuar(Jugador jugador){
        /* Le muestra al usuario una introduccion al juego (Instrucciones y pueden incluir una historia). */
        System.out.println("Bienvenido al juego JavaQuest!");
        System.out.println("Por favor, ingresa tu nombre:");
        jugador.setNombre(sc.nextLine());
        System.out.println("Hola " + jugador.getNombre() + "!");
        System.out.println("Tu objetivo es avanzar por el mapa hasta llegar al jefe final y derrotarlo.");
    }
}
