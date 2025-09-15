package co.edu.uniquindio.pr2;

import co.edu.uniquindio.pr2.factory.ModelFactory;
import co.edu.uniquindio.pr2.model.*;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        Biblioteca biblioteca = modelFactory.getBiblioteca();

        System.out.println("Usuarios");
        for (Usuario u : biblioteca.getUsuarios()) {
            System.out.println("ID: " + u.getIdUsuario() + " | Nombre: " + u.getNombreUsuario());
        }

        System.out.println("\nLibros");
        for (Libro l : biblioteca.getLibros()) {
            System.out.println("ISBN: " + l.getIsbn() + " | Título: " + l.getTitulo() + " | Estado: " + l.getEstado());
        }

        System.out.println("\nPréstamos");
        for (Prestamo p : biblioteca.getPrestamos()) {
            String estado = p.getFechaDevolucion() == null ? "Activo" : "Finalizado";
            System.out.println("Libro: " + p.getLibro().getTitulo() +
                    " | Usuario: " + p.getUsuario().getNombreUsuario() +
                    " | Estado: " + estado);
        }
    }
}