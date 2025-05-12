module com.alexander {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.alexander to javafx.fxml;
    exports com.alexander;
}
