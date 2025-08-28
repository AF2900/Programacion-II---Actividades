package co.edu.uniquindio.pr2.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private static Empresa instancia;
    private String nombre;
    private List<Videojuego> videojuegos;

    private Empresa(String nombre) {
        this.nombre = nombre;
        this.videojuegos = new ArrayList<>();
    }

    public static Empresa getInstancia(String nombre) {
        if (instancia == null) {
            instancia = new Empresa(nombre);
        }
        return instancia;
    }

    public void agregarVideojuego(Videojuego videojuego) {
        if (videojuego != null) {
            videojuegos.add(videojuego);
        }
    }

    public List<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}