package co.edu.uniquindio.pr2.factory;

import co.edu.uniquindio.pr2.model.*;
import co.edu.uniquindio.pr2.build.*;
import co.edu.uniquindio.pr2.service.IGestionInventario;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
    private static ModelFactory instance;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    private List<Libro> libros;
    private Bibliotecario bibliotecario;

    private ModelFactory() {
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.bibliotecario = new BibliotecarioBuilder()
                .nombre("Carlos")
                .idEmpleado("BIB001")
                .build();
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public void crearUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
        String id = JOptionPane.showInputDialog("Ingrese el ID del usuario:");
        Usuario usuario = new UsuarioBuilder()
                .nombreUsuario(nombre)
                .idUsuario(id)
                .build();
        usuarios.add(usuario);
        JOptionPane.showMessageDialog(null, "Usuario creado con éxito.");
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Usuarios registrados:\n");
        for (Usuario u : usuarios) {
            sb.append("ID: ").append(u.getIdUsuario())
                    .append(" | Nombre: ").append(u.getNombreUsuario())
                    .append(" | Préstamos: ").append(u.getPrestamos().size())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void actualizarUsuario() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del usuario a actualizar:");
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:", usuario.getNombreUsuario());
            usuario.setNombreUsuario(nuevoNombre);
            JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        }
    }

    public void eliminarUsuario() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del usuario a eliminar:");
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        }
    }

    // --------------------- CRUD LIBRO ---------------------
    public void crearLibro() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");
        Libro libro = new LibroBuilder()
                .titulo(titulo)
                .autor(autor)
                .isbn(isbn)
                .estado(Estado.DISPONIBLE)
                .build();
        libros.add(libro);
        JOptionPane.showMessageDialog(null, "Libro creado con éxito.");
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Libros registrados:\n");
        for (Libro l : libros) {
            sb.append("ISBN: ").append(l.getIsbn())
                    .append(" | Título: ").append(l.getTitulo())
                    .append(" | Autor: ").append(l.getAutor())
                    .append(" | Estado: ").append(l.getEstado())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public Libro buscarLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public void actualizarLibro() {
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro a actualizar:");
        Libro libro = buscarLibro(isbn);
        if (libro != null) {
            String nuevoTitulo = JOptionPane.showInputDialog("Nuevo título:", libro.getTitulo());
            String nuevoAutor = JOptionPane.showInputDialog("Nuevo autor:", libro.getAutor());
            libro.setTitulo(nuevoTitulo);
            libro.setAutor(nuevoAutor);
            JOptionPane.showMessageDialog(null, "Libro actualizado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        }
    }

    public void eliminarLibro() {
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro a eliminar:");
        Libro libro = buscarLibro(isbn);
        if (libro != null) {
            libros.remove(libro);
            JOptionPane.showMessageDialog(null, "Libro eliminado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        }
    }

    public void crearPrestamo() {
        String idUsuario = JOptionPane.showInputDialog("Ingrese el ID del usuario que hará el préstamo:");
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario != null) {
            String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");
            Libro libro = buscarLibro(isbn);
            if (libro == null) {
                JOptionPane.showMessageDialog(null, "El libro no existe. Primero créelo en el sistema.");
                return;
            }
            if (libro.getEstado() == Estado.PRESTADO) {
                JOptionPane.showMessageDialog(null, "El libro ya está prestado.");
                return;
            }
            Prestamo prestamo = new PrestamoBuilder()
                    .libro(libro)
                    .usuario(usuario)
                    .fechaPrestamo(java.time.LocalDate.now())
                    .build();

            usuario.getPrestamos().add(prestamo);
            prestamos.add(prestamo);
            libro.setEstado(Estado.PRESTADO);
            JOptionPane.showMessageDialog(null, "Préstamo creado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        }
    }

    public void listarPrestamos() {
        if (prestamos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay préstamos registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Préstamos registrados:\n");
        for (Prestamo p : prestamos) {
            String estado = p.getFechaDevolucion() == null ? "Activo" : "Finalizado";
            sb.append("Libro: ").append(p.getLibro().getTitulo())
                    .append(" | Usuario: ").append(p.getUsuario().getNombreUsuario())
                    .append(" | Estado: ").append(estado)
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void actualizarPrestamo() {
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro del préstamo a actualizar:");
        Prestamo prestamoEncontrado = null;
        for (Prestamo p : prestamos) {
            if (p.getLibro().getIsbn().equals(isbn)) {
                prestamoEncontrado = p;
                break;
            }
        }
        if (prestamoEncontrado != null) {
            String opcion = JOptionPane.showInputDialog("¿Desea marcar como devuelto? (si/no)");
            if (opcion != null && opcion.equalsIgnoreCase("si")) {
                prestamoEncontrado.setFechaDevolucion(java.time.LocalDate.now());
                prestamoEncontrado.getLibro().setEstado(Estado.DISPONIBLE);
            }
            JOptionPane.showMessageDialog(null, "Préstamo actualizado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Préstamo no encontrado.");
        }
    }

    public void eliminarPrestamo() {
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro del préstamo a eliminar:");
        Prestamo prestamoEliminar = null;
        for (Prestamo p : prestamos) {
            if (p.getLibro().getIsbn().equalsIgnoreCase(isbn)) {
                prestamoEliminar = p;
                break;
            }
        }
        if (prestamoEliminar != null) {
            prestamos.remove(prestamoEliminar);
            prestamoEliminar.getUsuario().getPrestamos().remove(prestamoEliminar);
            prestamoEliminar.getLibro().setEstado(Estado.DISPONIBLE);
            JOptionPane.showMessageDialog(null, "Préstamo eliminado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Préstamo no encontrado.");
        }
    }

    public void gestionarInventario() {
        IGestionInventario gestor = bibliotecario;
        gestor.gestionarItem();
    }
}