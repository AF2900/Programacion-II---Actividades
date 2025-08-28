package co.edu.uniquindio.pr2.model;

public class ShooterOnline extends Shooter implements IOnlineJugable, IMultijugador {
    public ShooterOnline(String nombre) {
        super(nombre);
    }

    @Override
    public void conectarOnline() {
        System.out.println(nombre + " se conecta online.");
    }

    @Override
    public void jugarMultijugador() {
        System.out.println(nombre + " en partida multijugador.");
    }

}
