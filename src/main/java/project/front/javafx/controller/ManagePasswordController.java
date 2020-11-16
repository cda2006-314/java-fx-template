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
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import project.front.javafx.FXMLDocumentController;

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
    @FXML
    private Button Back_Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(account_SubmitNewPassword_Button);
        AquaFx.createPasswordFieldStyler().style(account_formerPassword_PasswordField);
        AquaFx.createPasswordFieldStyler().style(account_newPassword_PasswordField);

        Button tbBack = Back_Button;
        AquaFx.createButtonStyler().setIcon(MacOSDefaultIcons.LEFT).setType(ButtonType.LEFT_PILL).style(tbBack);
        Back_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) Back_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("../FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
}
