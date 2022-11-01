package Code.Nodos;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Code.Jugador;

public class NodoInicial extends Nodo {
    public NodoInicial(int id, Random random, Scanner scanner) {
        super(id, random, scanner);
    }

    private static void wait (int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void interactuar(Jugador jugador){
        /* Le muestra al usuario una introduccion al juego (Instrucciones y pueden incluir una historia). */
        int time = 800;
        System.out.println("Bienvenido al juego JavaQuest!");
        System.out.println("Por favor, ingresa tu nombre:");
        jugador.setNombre(sc.nextLine());
        wait(time);
        System.out.println("Hola " + jugador.getNombre() + "!");
        wait(time);
        System.out.println("Tu objetivo es avanzar por el mapa hasta llegar al jefe final y derrotarlo.");
        wait(time);
        System.out.println("El mapa se compone de 3 tipos de nodos sin contar el actual y el del jefe final: Tienda, Combate y Evento");
        wait(time);
        System.out.println("En las tiendas puedes comprar items para mejorar tu personaje.");
        wait(time);
        System.out.println("En los nodos Combate debes enfrentarte a enemigos.");
        wait(time);
        System.out.println("En los nodos Evento puedes encontrar items.");
        wait(time);
        System.out.println("");
        wait(time);
        System.out.println("Cada vez que interactues con un nodo podras elegir 4 opciones:");
        wait(time);
    }
}
