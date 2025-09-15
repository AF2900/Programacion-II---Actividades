package co.edu.uniquindio.pr2.model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombreB;
    private String nit;
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    private List<Bibliotecario> bibliotecarios;

    public Biblioteca(String nombreB, String nit) {
        this.nombreB = nombreB;
        this.nit = nit;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.bibliotecarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public boolean actualizarUsuario(String id, String nuevoNombre) {
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            usuario.setNombreUsuario(nuevoNombre);
            return true;
        }
        return false;
    }

    public boolean eliminarUsuario(String id) {
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public Libro buscarLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public boolean actualizarLibro(String isbn, String nuevoTitulo, String nuevoAutor) {
        Libro libro = buscarLibro(isbn);
        if (libro != null) {
            libro.setTitulo(nuevoTitulo);
            libro.setAutor(nuevoAutor);
            return true;
        }
        return false;
    }

    public boolean eliminarLibro(String isbn) {
        Libro libro = buscarLibro(isbn);
        if (libro != null) {
            libros.remove(libro);
            return true;
        }
        return false;
    }

    public boolean registrarPrestamo(Prestamo prestamo) {
        Usuario usuario = prestamo.getUsuario();
        Libro libro = prestamo.getLibro();

        if (usuario != null && libro != null && libro.getEstado() == Estado.DISPONIBLE) {
            prestamos.add(prestamo);
            usuario.getPrestamos().add(prestamo);
            libro.setEstado(Estado.PRESTADO);
            return true;
        }
        return false;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public boolean actualizarPrestamo(String isbn, boolean devolver) {
        for (Prestamo p : prestamos) {
            if (p.getLibro().getIsbn().equals(isbn)) {
                if (devolver) {
                    p.setFechaDevolucion(java.time.LocalDate.now());
                    p.getLibro().setEstado(Estado.DISPONIBLE);
                }
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPrestamo(String isbn) {
        Prestamo prestamoEliminar = null;
        for (Prestamo p : prestamos) {
            if (p.getLibro().getIsbn().equals(isbn)) {
                prestamoEliminar = p;
                break;
            }
        }
        if (prestamoEliminar != null) {
            prestamos.remove(prestamoEliminar);
            prestamoEliminar.getUsuario().getPrestamos().remove(prestamoEliminar);
            prestamoEliminar.getLibro().setEstado(Estado.DISPONIBLE);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombreB='" + nombreB + '\'' +
                ", nit='" + nit + '\'' +
                '}';
    }
}