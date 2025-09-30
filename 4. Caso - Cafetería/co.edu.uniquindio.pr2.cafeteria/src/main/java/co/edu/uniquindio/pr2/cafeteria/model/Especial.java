package co.edu.uniquindio.pr2.cafeteria.model;

public class Especial extends CafeDecorator {

    public Especial(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " (Especial)";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 1000;
    }
}