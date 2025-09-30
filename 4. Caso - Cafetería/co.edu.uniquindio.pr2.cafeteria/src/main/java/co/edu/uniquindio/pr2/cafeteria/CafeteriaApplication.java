package co.edu.uniquindio.pr2.cafeteria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CafeteriaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CafeteriaApplication.class.getResource("cafeteria.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menú prueba");
        stage.setScene(scene);
        stage.show();
    }
}
