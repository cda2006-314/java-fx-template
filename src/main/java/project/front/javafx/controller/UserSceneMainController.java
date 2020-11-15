 package project.front.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Charlène
 */
public class UserSceneMainController implements Initializable {

    @FXML
    private Button user_SearchUser_Button;
    @FXML
    private TextField user_SearchLogin_TextField;
    @FXML
    private TextField user_SearchEvent_Textfield;
    @FXML
    private ComboBox<?> user_SearchStatus_CB;
    @FXML
    private AnchorPane user_ResultSearch_AnchorPane;
    @FXML
    private TableView<?> user_AllUsers_Table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
