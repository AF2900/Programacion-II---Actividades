package co.edu.uniquindio.pr2.build;

import co.edu.uniquindio.pr2.model.Bibliotecario;
import co.edu.uniquindio.pr2.model.Libro;
import co.edu.uniquindio.pr2.model.Prestamo;
import java.util.ArrayList;
import java.util.List;

public class BibliotecarioBuilder {
    private String nombre;
    private String idEmpleado;
    List<Libro> libros = new ArrayList();
    List<Prestamo> prestamosB = new ArrayList();

    public BibliotecarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public BibliotecarioBuilder idEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
        return this;
    }

    public BibliotecarioBuilder libros(List<Libro> libros) {
        this.libros = libros;
        return this;
    }

    public BibliotecarioBuilder prestamosB(List<Prestamo> prestamosB) {
        this.prestamosB = prestamosB;
        return this;
    }

    public Bibliotecario build() {
        return new Bibliotecario(nombre, idEmpleado, prestamosB, libros);
    }
}