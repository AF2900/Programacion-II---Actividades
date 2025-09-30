package co.edu.uniquindio.pr2.cafeteria.model;

public class Canela extends CafeDecorator {
    public Canela(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Canela";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 400;
    }
}

