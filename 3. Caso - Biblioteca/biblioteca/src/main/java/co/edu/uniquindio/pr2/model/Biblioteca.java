package co.edu.uniquindio.pr2.model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public String nombreB;
    public String nit;
    List <Libro> libros = new ArrayList<>();
    List <Usuario> usuarios = new ArrayList<>();
    List <Prestamo> prestamos = new ArrayList<>();
    List <Bibliotecario> bibliotecarios = new ArrayList<>();


    public Biblioteca(String nombreB, String nit) {
        this.nombreB = nombreB;
        this.nit = nit;
    }

    public void setNombreB(String nombreB) {
        this.nombreB = nombreB;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombreB='" + nombreB + '\'' +
                ", nit='" + nit + '\'' +
                '}';
    }
}