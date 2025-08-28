package co.edu.uniquindio.pr2.model;

public abstract class Videojuego {
    protected String nombre;
    protected String genero;

    public Videojuego(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public abstract void jugar();
}