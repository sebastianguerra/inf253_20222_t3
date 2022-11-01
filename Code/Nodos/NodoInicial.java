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
        System.out.println("El mapa se compone de 3 tipos de nodos sin contar el actual y el del jefe final: Tienda, Combate y Evento");
        System.out.println("En las tiendas puedes comprar items para mejorar tu personaje.");
        System.out.println("En los nodos Combate debes enfrentarte a enemigos.");
        System.out.println("En los nodos Evento puedes encontrar items.");
        System.out.println("");
        System.out.println("Cada vez que interactues con un nodo podras elegir 4 opciones:");
    }
}
