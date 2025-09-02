package co.edu.uniquindio.pr2.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombreUsuario;
    private String idUsuario;
    private List<Prestamo> prestamos;


    public Usuario(String nombreUsuario, String idUsuario, List<Prestamo> prestamos) {
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
        this.prestamos = new ArrayList<>();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", prestamos=" + prestamos +
                '}';
    }
}