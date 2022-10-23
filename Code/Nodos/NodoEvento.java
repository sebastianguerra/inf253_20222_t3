package Code.Nodos;

import Code.Item;
import Code.Jugador;

public class NodoEvento extends Nodo {
    private String descripcion; // Pequenia historia que describe un encuentro del jugador en su aventura.
    private String alterntiva1; // Dos opciones que puede tomar en el encuentro descrito
    private String alterntiva2; // Dos opciones que puede tomar en el encuentro descrito
    private Item resultado1; // Item que el jugador puede obtener si toma la primera opcion.
    private Item resultado2; // Item que el jugador puede obtener si toma la segunda opcion.

    public NodoEvento(int id) {
        super(id);
    }

    public void interactuar(Jugador jugador){
        /* Le muestra al usuario la descripcion del evento y las aalternativas que puede seleccionar (No se muestran explicitamente las recompensas asociadas a cada alternativa). Cuando el usuario selecciona una alternativa se le aplica la recompensa correspondiente */
        // TODO
    }
}
