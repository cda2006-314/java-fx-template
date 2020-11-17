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
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import project.front.javafx.FXMLDocumentController;

 /**
 * FXML Controller class
 *
 * @author Charlène
 */

 @Component
public class ModerateManegeMainController implements Initializable {

    @FXML
    private TableView<?> moderate_EventToModerate_Table;
    @FXML
    private TableView<?> moderate_CommentsToModerate_Table;
    @FXML
    private TableView<?> moderate_UsersToModerate_Table;
    @FXML
    private TableView<?> moderate_AccountToValidate_Table;
    @FXML
    private Button Back_Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
