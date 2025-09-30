package co.edu.uniquindio.pr2.reproductorvideo.strategy;

public interface ReproductorStrategy {
    void reproducir(String nombreArchivo, java.util.function.Consumer<String> mostrarMensaje);
}