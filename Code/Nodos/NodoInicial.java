package Code.Nodos;

import Code.Jugador;

public class NodoInicial extends Nodo {
    public NodoInicial(int id) {
        super(id);
    }

    public void interactuar(Jugador jugador){
        /* Le muestra al usuario una introduccion al juego (Instrucciones y pueden incluir una historia). */
        System.out.println("Bienvenido al juego de aventura");
    }
}
