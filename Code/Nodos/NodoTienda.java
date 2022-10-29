package Code.Nodos;

import java.util.List;

import Code.Item;
import Code.Jugador;

public class NodoTienda extends Nodo {
    private List<Item> inventario; // Lista de items disponibles para comprar.

    public NodoTienda(int id) {
        super(id);
    }

    public void comprar(Integer pos){
        /* Le aplica el item en la posicion indicada al jugador. */
        // TODO
    }
    public void interactuar(Jugador jugador) {
        /* Le muestra los items en el inventario de la tienda al usuario y cuanto dinero tiene a su disposicion. Le permite comprar tantos items como quiera. */
        for ( Item i : inventario) {
            System.out.println(i.getName());
        }
    }
}
