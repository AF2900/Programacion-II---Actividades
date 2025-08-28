package co.edu.uniquindio.pr2.builder;

import co.edu.uniquindio.pr2.model.Propietario;
import co.edu.uniquindio.pr2.model.Vehiculo;

public class PropietarioBuilder {
    private String nombre;
    private String id;
    private String correo;
    private String celular;
    private String sizeVehiculo;
    private Vehiculo vehiculo;

    public PropietarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PropietarioBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PropietarioBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public PropietarioBuilder celular(String celular) {
        this.celular = celular;
        return this;
    }

    public PropietarioBuilder sizeVehiculo(String sizeVehiculo) {
        this.sizeVehiculo = sizeVehiculo;
        return this;
    }

    public PropietarioBuilder vehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        return this;
    }

    public Propietario build() {
        Propietario propietario = new Propietario(nombre, id, correo, celular, sizeVehiculo);
        propietario.setVehiculo(vehiculo);
        return propietario;
    }
}