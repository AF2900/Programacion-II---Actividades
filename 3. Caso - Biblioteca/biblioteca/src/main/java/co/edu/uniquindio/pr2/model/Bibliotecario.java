package co.edu.uniquindio.pr2.model;

import co.edu.uniquindio.pr2.service.IGestionInventario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado implements IGestionInventario {
    List <Libro> libros = new ArrayList();
    List <Prestamo> prestamos = new ArrayList();

    public Bibliotecario(String nombre, String idEmpleado, List<Prestamo> prestamos, List<Libro> libros) {
        super(nombre, idEmpleado);
    }

    public void gestionarItem() {
        JOptionPane.showMessageDialog(null,"Gestionando Item...");
        JOptionPane.showMessageDialog(null,"Sus items han sido gestionados, " +
                "ahora puede realizar sus operaciones libremente");
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}