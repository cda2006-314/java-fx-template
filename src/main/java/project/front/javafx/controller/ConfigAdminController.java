 package project.front.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Charlène
 */
public class ConfigAdminController implements Initializable {

    @FXML
    private AnchorPane configuration_AnchorPane;
    @FXML
    private TextField config_SearchAdmin_TxtField;
    @FXML
    private Button config_CreateAdmin_Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
