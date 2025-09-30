package co.edu.uniquindio.pr2.cafeteria.model;

public class Leche extends CafeDecorator {

    public Leche(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Leche";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 500;
    }
}