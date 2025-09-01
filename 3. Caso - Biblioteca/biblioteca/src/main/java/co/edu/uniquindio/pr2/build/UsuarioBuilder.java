package co.edu.uniquindio.pr2.build;

import co.edu.uniquindio.pr2.model.Prestamo;
import co.edu.uniquindio.pr2.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioBuilder {
    private String nombreUsuario;
    private String idUsuario;
    private List<Prestamo> prestamos = new ArrayList<>();

    public UsuarioBuilder nombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public UsuarioBuilder idUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioBuilder prestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
        return this;
    }

    public Usuario build() {
        return new Usuario(nombreUsuario, idUsuario, prestamos);
    }
}