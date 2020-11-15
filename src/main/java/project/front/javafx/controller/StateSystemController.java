 package project.front.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Charlène
 */
public class StateSystemController implements Initializable {

    @FXML
    private AnchorPane StateSystemAnchorPane;
    @FXML
    private Label stateSystem_ReturnStateServer_Label;
    @FXML
    private Label StateSystem_ReturnStateBDD_Label;
    @FXML
    private Label stateSystem_ReturnStateApi_Label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
