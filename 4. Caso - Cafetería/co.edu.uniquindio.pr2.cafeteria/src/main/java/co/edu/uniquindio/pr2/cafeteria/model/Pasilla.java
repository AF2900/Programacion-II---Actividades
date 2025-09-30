package co.edu.uniquindio.pr2.cafeteria.model;

public class Pasilla extends CafeDecorator {

    public Pasilla(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " (Pasilla)";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 800;
    }
}