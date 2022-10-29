package Code.Nodos;

import Code.Personaje;
import Code.Jugador;

public class NodoJefeFinal extends Nodo {
    private Personaje jefe; // Enemigo al cual se debe enfrentar el jugador.

    public NodoJefeFinal(int id) {
        super(id);
    }

    public void interactuar(Jugador jugador){
        /* Realiza el combate informandole al usuaio los resultados de cada ataque realizado y determina al ganador. */
        jugador.combate(jefe);
    }
}
