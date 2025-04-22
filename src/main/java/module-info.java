module com.alexander {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.alexander to javafx.fxml;
    exports com.alexander;
}
