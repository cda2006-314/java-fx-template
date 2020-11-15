 package project.front.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Charlène
 */
public class ManageAccountController implements Initializable {

    @FXML
    private Button account_UpdatingPassword_Button;
    @FXML
    private Label account_Welcoming_Label;
    @FXML
    private AnchorPane account_ReceiveChangePasswd_Pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
