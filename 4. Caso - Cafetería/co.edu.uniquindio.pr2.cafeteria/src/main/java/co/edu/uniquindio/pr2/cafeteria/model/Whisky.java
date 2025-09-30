package co.edu.uniquindio.pr2.cafeteria.model;

public class Whisky extends CafeDecorator {
    public Whisky(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Whisky";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 1500;
    }
}

