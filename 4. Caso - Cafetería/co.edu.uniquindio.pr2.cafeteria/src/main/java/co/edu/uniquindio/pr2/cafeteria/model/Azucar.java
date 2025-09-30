package co.edu.uniquindio.pr2.cafeteria.model;

public class Azucar extends CafeDecorator {
    public Azucar(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Azúcar";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 300;
    }
}
