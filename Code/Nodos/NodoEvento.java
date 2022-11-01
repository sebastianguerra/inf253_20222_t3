package Code.Nodos;

import java.util.Random;
import java.util.Scanner;

import Code.Item;
import Code.Jugador;

public class NodoEvento extends Nodo {
    private String descripcion; // Pequenia historia que describe un encuentro del jugador en su aventura.
    private String alternativa1; // Primera opcion que puede tomar en el encuentro descrito
    private String alternativa2; // Primera opcion que puede tomar en el encuentro descrito
    private Item resultado1; // Item que el jugador puede obtener si toma la primera opcion.
    private Item resultado2; // Item que el jugador puede obtener si toma la segunda opcion.

    public NodoEvento(int id, Random random, Scanner scanner) {
        super(id, random, scanner);
    }

    public void interactuar(Jugador jugador){
        /* Le muestra al usuario la descripcion del evento y las aalternativas que puede seleccionar (No se muestran explicitamente las recompensas asociadas a cada alternativa). Cuando el usuario selecciona una alternativa se le aplica la recompensa correspondiente */
        System.out.println(descripcion);

        System.out.println("Opciones:");

        System.out.println("\t1.- "+alternativa1);
        System.out.println("\t2.- "+alternativa2);

        System.out.println("Eleccion: ");
        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();

        if ( eleccion == 1 ) {
            jugador.aplicarItem(resultado1);
        } else {
            jugador.aplicarItem(resultado2);
        }
    }
}
