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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Charlène
 */
public class ConfigCreateAdminController implements Initializable {

    @FXML
    private TextField configure_LoginNewAdmin_TxtField;
    @FXML
    private TextField configure_NewAdminPassword_Textfield;
    @FXML
    private Button configure_CreateAdmin_Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
