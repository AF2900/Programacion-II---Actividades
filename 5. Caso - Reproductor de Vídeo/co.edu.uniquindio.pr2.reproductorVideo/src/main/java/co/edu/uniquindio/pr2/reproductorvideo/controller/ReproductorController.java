package co.edu.uniquindio.pr2.reproductorvideo.controller;

import co.edu.uniquindio.pr2.reproductorvideo.strategy.SimpleReproductor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.File;

public class ReproductorController {

    @FXML
    private Button btCargarArchivo;

    @FXML
    private Button btReproducirVideo;

    @FXML
    private TextArea txtNombreArchivo;

    @FXML
    private TextArea txtReproduciendo;

    private VideoFacade videoFacade;
    private File archivoSeleccionado;

    @FXML
    void initialize() {
        videoFacade = new VideoFacade(new SimpleReproductor());
    }

    @FXML
    void onCargarArchivo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo de video");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Video", "*.mp4", "*.avi", "*.mkv")
        );

        archivoSeleccionado = fileChooser.showOpenDialog(null);

        if (archivoSeleccionado != null) {
            txtNombreArchivo.setText(archivoSeleccionado.getName());
            videoFacade.cargarArchivo(archivoSeleccionado);
        }
    }

    @FXML
    void onReproducirVideo(ActionEvent event) {
        videoFacade.reproducir(mensaje -> txtReproduciendo.setText(mensaje));
    }
}