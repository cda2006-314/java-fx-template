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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
public class ManageAccountController implements Initializable {

     @FXML
     private Button account_UpdatingPassword_Button;
     @FXML
     private Label account_Welcoming_Label;
     @FXML
     private AnchorPane account_ReceiveChangePasswd_Pane;
     @FXML
     private Button Back_Button;


     @Autowired
     Navigation navigation;

     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {

         account_Welcoming_Label.setText(LoginController.usernameManager);

         AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(account_UpdatingPassword_Button);

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

         account_UpdatingPassword_Button.setOnAction((ActionEvent event) -> {
             try {
                 Stage stage = (Stage) Back_Button.getScene().getWindow();
                 navigation.setStage(stage);
                 navigation.showManagePasswordView();
             } catch (Exception ex) {
                 Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
             }
         });

     }
 }
