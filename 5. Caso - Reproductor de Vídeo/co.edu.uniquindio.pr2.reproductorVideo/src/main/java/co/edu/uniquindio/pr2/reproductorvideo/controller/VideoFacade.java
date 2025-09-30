package co.edu.uniquindio.pr2.reproductorvideo.controller;

import co.edu.uniquindio.pr2.reproductorvideo.strategy.ReproductorStrategy;
import java.io.File;

public class VideoFacade {
    private ReproductorStrategy strategy;
    private File archivo;

    public VideoFacade(ReproductorStrategy strategy) {
        this.strategy = strategy;
    }

    public void cargarArchivo(File archivo) {
        if (archivo != null && archivo.exists()) {
            this.archivo = archivo;
        } else {
            throw new IllegalArgumentException("Archivo no válido");
        }
    }

    public void reproducir(java.util.function.Consumer<String> mostrarMensaje) {
        if (archivo != null) {
            strategy.reproducir(archivo.getName(), mostrarMensaje);
        } else {
            mostrarMensaje.accept("No se ha cargado ningún archivo.");
        }
    }
}