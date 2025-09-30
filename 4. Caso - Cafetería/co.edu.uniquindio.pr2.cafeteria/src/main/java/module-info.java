module co.edu.uniquindio.pr2.cafeteria {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.pr2.cafeteria to javafx.fxml;
    opens co.edu.uniquindio.pr2.cafeteria.controller to javafx.fxml;
    exports co.edu.uniquindio.pr2.cafeteria;
}