package Code;

import java.util.Random;

public class Personaje {
    private String nombre; // Nombre del personaje.
    private Integer dinero; // Cuanto dinero tiene el personaje.
    protected Integer hp_actual; // Cantidad de vida que tiene actualmente el personaje.
    protected Integer hp_total; // Cantidad de vida maxima que puede tener el personaje.
    protected Integer danio; // Cantidad de vida que le resta a su oponente al combatir (antes de aplicar defensa).
    protected Integer defensa; // Cantidad de danio evitado por golpe al combatir.

    private Random rand;

    public Personaje(Random random, String nombre, Integer dinero, Integer hp_actual, Integer hp_total, Integer danio, Integer defensa) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.hp_actual = hp_actual;
        this.hp_total = hp_total;
        this.danio = danio;
        this.defensa = defensa;

        this.rand = random;
    }


    public void combate(Personaje enemigo) {
        /* Realiza el combate entre dos personajes. Durante un combate se selecciona un personaje aleatoriamente para comenzar y posteriormente se alternan al atacar. Durante un ataque, el personaje defensor pierde vida equivalente al danio de su oponente menos la defensa del defensor. El combate termina un vez la hp_actual de uno de los personajes sea menor o igual a 0. */
        Boolean turnoEnemigo = rand.nextBoolean();

        while (enemigo.stillAlive() && this.stillAlive()) {
            if (turnoEnemigo)
                this.recibirAtaque(enemigo.getDanio());
            else
                enemigo.recibirAtaque(this.getDanio());
        }

    }

    public void recibirAtaque(int danio) {
        this.hp_actual -= danio - this.defensa;
    }

    public int getDanio(){
        return this.danio;
    }

    public boolean stillAlive(){
        return this.hp_actual>0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }
}
