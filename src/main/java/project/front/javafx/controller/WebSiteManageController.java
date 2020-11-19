 package project.front.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

 /**
 * FXML Controller class
 *
 * @author Charlène
 */

 @Component
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
    @FXML
    private Button Back_Button;
     @Autowired
     Navigation navigation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AquaFx.createComboBoxStyler().style(ManageWebSite_ShowPages_CB);
        AquaFx.createComboBoxStyler().style(ManageWebSite_ShowImages_CB);
        AquaFx.createComboBoxStyler().style(ManageWebSite_ShowFont_CB);
        AquaFx.createComboBoxStyler().style(ManageWebSite_ShowApi_CB);
        Button tbBack = Back_Button;
        AquaFx.createButtonStyler().setIcon(MacOSDefaultIcons.LEFT).setType(ButtonType.LEFT_PILL).style(tbBack);

        Back_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) Back_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showWelcomeView();
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
}
