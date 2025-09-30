module co.edu.uniquindio.pr2.reproductorvideo {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.pr2.reproductorvideo to javafx.fxml;
    exports co.edu.uniquindio.pr2.reproductorvideo;
    exports co.edu.uniquindio.pr2.reproductorvideo.controller;
    opens co.edu.uniquindio.pr2.reproductorvideo.controller to javafx.fxml;
}