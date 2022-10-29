package Code;

public class Item {
    private Integer precio; // Corresponde a cuanto dinero cuesta adquirir un item desde la tienda.
    private Integer recuperar_hp; // Cantidad de hp que recupera al jugador.
    private Integer aumentar_hp_total; // Cantidad de hp_total que aumenta al jugador. Un aumento de hp_total no afecta a la hp_actual.
    private Integer aumentar_danio; // Cantidad de danio que aumenta al jugador.
    private Integer aumentar_defensa; // Cantidad de defensa que aumenta al jugador.

    public void aplicar(Jugador jugador){
        /* Agrega el item a la lista de items aplicados del jugador y aplica sus estadisticas. */
        jugador.aplicarItem(this);
    }

    public Integer getAumentoDanio() {
        return this.aumentar_danio;
    }
    public Integer getAumentoHPTotal() {
        return this.aumentar_hp_total;
    }
    public Integer getAumentoHP() {
        return this.recuperar_hp;
    }
    public Integer getAumentoDefensa() {
        return this.aumentar_defensa;
    }

    public Integer getPrecio() {
        return this.precio;
    }

    public String getName() {
        return "asdf";
    }
}
