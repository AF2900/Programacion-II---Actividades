package co.edu.uniquindio.pr2.reproductorvideo.strategy;

public class SimpleReproductor implements ReproductorStrategy {

    @Override
    public void reproducir(String nombreArchivo, java.util.function.Consumer<String> mostrarMensaje) {
        mostrarMensaje.accept("Reproduciendo: " + nombreArchivo);
    }
}