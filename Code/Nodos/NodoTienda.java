package Code.Nodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Code.Item;
import Code.Jugador;

public class NodoTienda extends Nodo {
    private List<Item> inventario; // Lista de items disponibles para comprar.

    public NodoTienda(int id, Random random, Scanner scanner) {
        super(id, random, scanner);
        this.inventario = new ArrayList<>();
        final int cantidadItems = random.nextInt(4) + 5; // Cantidad de items que tendra la tienda.
        for (int i = 0; i < cantidadItems; i++) {
            inventario.add(Item.generarItemAleatorio(random));
        }
    }

    public void comprar(Integer pos, Jugador jugador){
        // TODO poder comprar mas que un item
        /* Le aplica el item en la posicion indicada al jugador. */
        jugador.aplicarItem(inventario.get(pos));
        jugador.cobrar(inventario.get(pos).getPrecio());
    }
    public void interactuar(Jugador jugador) {
        // TODO poder comprar mas que un item
        /* Le muestra los items en el inventario de la tienda al usuario y cuanto dinero tiene a su disposicion. Le permite comprar tantos items como quiera. */
        System.out.println("Bienvenido a la tienda!");
        // System.out.println("Tienes "+jugador.getDinero()+" dinero.");
        jugador.verEstado();
        System.out.println("Inventario:");
        System.out.println("-----------------------------------");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.printf("%d:\n", i+1);
            inventario.get(i).showInfo();
            System.out.println("-----------------------------------");
        }
        System.out.println("Que deseas comprar? (Ingresa el numero del item que deseas comprar, 0 para omitir)");
        int eleccion = sc.nextInt();
        boolean eleccionValida = false;
        while(!eleccionValida) {
            if ( eleccion == 0 ) {
                eleccionValida = true;
            } else if ( eleccion > 0 && eleccion <= inventario.size() ) {
                if ( jugador.getDinero() >= inventario.get(eleccion-1).getPrecio() ) {
                    comprar(eleccion-1, jugador);
                    eleccionValida = true;
                } else {
                    System.out.println("No tienes suficiente dinero para comprar este item.");
                    eleccion = sc.nextInt();
                }
            } else {
                System.out.println("Opcion invalida.");
                eleccion = sc.nextInt();
            }
        }
    }
}
