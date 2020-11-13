/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitestproject.controllers;

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
