package co.edu.uniquindio.pr2.build;

import co.edu.uniquindio.pr2.model.Estado;
import co.edu.uniquindio.pr2.model.Libro;

public class LibroBuilder {
    private String titulo;
    private String autor;
    private String isbn;
    private Estado estado;

    public LibroBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LibroBuilder autor(String autor) {
        this.autor = autor;
        return this;
    }

    public LibroBuilder isbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public LibroBuilder estado(Estado estado) {
        this.estado = estado;
        return this;
    }

    public Libro build() {
        return new Libro(titulo, autor, isbn, estado);
    }
}