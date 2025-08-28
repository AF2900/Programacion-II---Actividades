package co.edu.uniquindio.pr2;

import co.edu.uniquindio.pr2.model.*;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = Empresa.getInstancia("Universal Games");

        Videojuego zelda = new RPG("Zelda");
        Videojuego cod = new ShooterOnline("Call of Duty");

        empresa.agregarVideojuego(zelda);
        empresa.agregarVideojuego(cod);

        for (Videojuego v : empresa.getVideojuegos()) {
            v.jugar();

            if (v instanceof IOnlineJugable) {
                ((IOnlineJugable) v).conectarOnline();
            }
            if (v instanceof IMultijugador) {
                ((IMultijugador) v).jugarMultijugador();
            }
        }
    }
}