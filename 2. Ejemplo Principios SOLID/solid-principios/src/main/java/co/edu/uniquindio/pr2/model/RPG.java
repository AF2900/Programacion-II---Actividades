package co.edu.uniquindio.pr2.model;

public class RPG extends Videojuego {
    public RPG(String nombre) {
        super(nombre, "RPG");
    }

    @Override
    public void jugar() {
        System.out.println("Jugando al RPG: " + nombre);
    }
}