package co.edu.uniquindio.pr2.builder;

import co.edu.uniquindio.pr2.model.Usuario;

public class UsuarioBuilder {
    private int edad;

    public UsuarioBuilder edad(int edad) {
        this.edad = edad;
        return this;
    }

    public Usuario build() {
        return new Usuario(edad);
    }
}