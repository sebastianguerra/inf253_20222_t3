package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jugador extends Personaje {
    private List<Item> items_aplicados; // Una lista con los items que el personaje a adquirido durante su aventura.

    public Jugador(Random rand) {
        super(rand, null, 500, 20, 20, 5, 1);
        items_aplicados = new ArrayList<Item>();
    }

    public void verEstado(){
        /* Muestra al usuario los atributos actuales del jugador (nombre, dinero, hp_actual, hp_total, danio y defensa) */
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Dinero: " + this.getDinero());
        System.out.printf("HP: %d/%d\n", this.getHp_actual(), this.getHp_total());
        System.out.println("Danio: " + this.getDanio());
        System.out.println("Defensa: " + this.getDefensa());
    }
    public void verItems(){
        /* Muestra al usuario los items que a adquirido. */
        // TODO
    }

    public void aplicarItem(Item item) {
        items_aplicados.add(item);
        this.danio += item.getAumentoDanio();
        this.hp_total += item.getAumentoHPTotal();
        this.hp_actual += item.getAumentoHP();
        this.hp_actual = Math.min(this.hp_actual, this.hp_total);
        this.defensa += item.getAumentoDefensa();

    }
}
