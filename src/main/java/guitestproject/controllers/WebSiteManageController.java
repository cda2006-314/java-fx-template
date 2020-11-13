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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class
 *
 * @author Charlène
 */
public class WebSiteManageController implements Initializable {

    @FXML
    private ComboBox<?> ManageWebSite_ShowApi_CB;
    @FXML
    private ComboBox<?> ManageWebSite_ShowFont_CB;
    @FXML
    private ComboBox<?> ManageWebSite_ShowImages_CB;
    @FXML
    private ComboBox<?> ManageWebSite_ShowPages_CB;
    @FXML
    private TreeView<?> ManageWebSite_AssocPreference_TreeView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
