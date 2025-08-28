package co.edu.uniquindio.pr2.model;

public class Shooter extends Videojuego {
    public Shooter(String nombre) {
        super(nombre, "Shooter");
    }

    @Override
    public void jugar() {
        System.out.println("Disparando en: " + nombre);
    }
}