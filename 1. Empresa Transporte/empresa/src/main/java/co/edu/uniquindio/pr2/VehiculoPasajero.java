package co.edu.uniquindio.pr2;

public class VehiculoPasajero extends Vehiculo {
    private int numeroMaximo;

    public VehiculoPasajero(String placa, String modelo, String marca, String color, int numeroMaximo) {
        super(placa, modelo, marca, color);
        this.numeroMaximo = numeroMaximo;
    }

    public int getNumeroMaximo() {
        return numeroMaximo;
    }

    public void setNumeroMaximo(int numeroMaximo) {
        this.numeroMaximo = numeroMaximo;
    }

    @Override
    public String toString() {
        return "VehiculoPasajero{" +
                "numeroMaximo=" + numeroMaximo +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}