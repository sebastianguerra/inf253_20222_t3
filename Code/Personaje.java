package Code;

public class Personaje {
    private String nombre; // Nombre del personaje.
    private Integer dinero; // Cuanto dinero tiene el personaje.
    private Integer hp_actual; // Cantidad de vida que tiene actualmente el personaje.
    private Integer hp_total; // Cantidad de vida maxima que puede tener el personaje.
    private Integer danio; // Cantidad de vida que le resta a su oponente al combatir (antes de aplicar defensa).
    private Integer defensa; // Cantidad de danio evitado por golpe al combatir.

    public Personaje(){} // TODO

    public void combate(Personaje enemigo) {
        /* Realiza el combate entre dos personajes. Durante un combate se selecciona un personaje aleatoriamente para comenzar y posteriormente se alternan al atacar. Durante un ataque, el personaje defensor pierde vida equivalente al danio de su oponente menos la defensa del defensor. El combate termina un vez la hp_actual de uno de los personajes sea menor o igual a 0. */
        // TODO
    }
}
