package co.edu.uniquindio.pr2.build;

import co.edu.uniquindio.pr2.model.Libro;
import co.edu.uniquindio.pr2.model.Prestamo;
import co.edu.uniquindio.pr2.model.Usuario;
import java.time.LocalDate;

public class PrestamoBuilder {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Libro libro;
    private Usuario usuario;

    public PrestamoBuilder fechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        return this;
    }

    public PrestamoBuilder fechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        return this;
    }

    public PrestamoBuilder libro(Libro libro) {
        this.libro = libro;
        return this;
    }

    public PrestamoBuilder usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Prestamo build() {
        return new Prestamo(libro, usuario);
    }
}