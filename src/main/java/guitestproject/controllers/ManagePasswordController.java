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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Charlène
 */
public class ManagePasswordController implements Initializable {

    @FXML
    private PasswordField account_formerPassword_PasswordField;
    @FXML
    private PasswordField account_newPassword_PasswordField;
    @FXML
    private Button account_SubmitNewPassword_Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
