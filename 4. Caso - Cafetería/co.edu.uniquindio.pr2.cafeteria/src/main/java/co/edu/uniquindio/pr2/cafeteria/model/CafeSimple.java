package co.edu.uniquindio.pr2.cafeteria.model;

public class CafeSimple implements Cafe {

    @Override
    public String getDescripcion() {
        return "Café simple";
    }

    @Override
    public double getCosto() {
        return 2000;
    }
}