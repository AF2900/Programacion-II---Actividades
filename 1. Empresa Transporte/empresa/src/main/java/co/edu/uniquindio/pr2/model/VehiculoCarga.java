package co.edu.uniquindio.pr2.model;

public class VehiculoCarga extends Vehiculo {
    private int numeroEjes;
    private int capacidadCarga;

    public VehiculoCarga(String placa, String modelo, String marca, String color, int numeroEjes, int capacidadCarga) {
        super(placa,modelo,marca,color);
        this.numeroEjes=numeroEjes;
        this.capacidadCarga=capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return "VehiculoCarga{" +
                "numeroEjes='" + numeroEjes + '\'' +
                ", capacidadCarga='" + capacidadCarga + '\'' +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}