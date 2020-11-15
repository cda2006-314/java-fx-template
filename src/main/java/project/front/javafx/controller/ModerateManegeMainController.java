 package project.front.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Charlène
 */
public class ModerateManegeMainController implements Initializable {

    @FXML
    private TableView<?> moderate_EventToModerate_Table;
    @FXML
    private TableView<?> moderate_CommentsToModerate_Table;
    @FXML
    private TableView<?> moderate_UsersToModerate_Table;
    @FXML
    private TableView<?> moderate_AccountToValidate_Table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
