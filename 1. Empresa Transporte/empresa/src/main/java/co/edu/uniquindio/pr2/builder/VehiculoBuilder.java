package co.edu.uniquindio.pr2.builder;

import co.edu.uniquindio.pr2.model.Vehiculo;

public class VehiculoBuilder {
    private String placa;
    private String modelo;
    private String marca;
    private String color;
    private int numeroEjes;
    private int capacidadCarga;

    public VehiculoBuilder placa(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoBuilder modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public VehiculoBuilder marca(String marca) {
        this.marca = marca;
        return this;
    }

    public VehiculoBuilder color(String color) {
        this.color = color;
        return this;
    }

    public Vehiculo build() {
        return new Vehiculo(placa, modelo, marca, color);
    }

    public VehiculoBuilder numeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
        return this;
    }

    public VehiculoBuilder capacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
        return this;
    }
}