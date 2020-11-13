module guitestproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens guitestproject to javafx.fxml;
    opens guitestproject.controllers to javafx.fxml;

    exports guitestproject;
    exports guitestproject.controllers;
}
