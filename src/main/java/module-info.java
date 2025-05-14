module com.alexander {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.alexander to javafx.fxml;
    exports com.alexander;
    exports com.alexander.controllers;
    opens com.alexander.controllers to javafx.fxml;
    exports com.alexander.Model;
    opens com.alexander.Model to javafx.fxml;
    exports com.alexander.Interfaces;
    
}
