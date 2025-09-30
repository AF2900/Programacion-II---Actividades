package co.edu.uniquindio.pr2.reproductorvideo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ReproductorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ReproductorApplication.class.getResource("Reproductor.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Reproductor de vídeo AF");
        stage.setScene(scene);
        stage.show();
    }
}
