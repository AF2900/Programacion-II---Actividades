package co.edu.uniquindio.pr2.model;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private Estado estado;

    public Libro(String titulo, String autor, String isbn, Estado estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", estado=" + estado +
                '}';
    }
}