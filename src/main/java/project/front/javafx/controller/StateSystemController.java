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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.services.StateSystemServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

 /**
 * FXML Controller class
 *
 * @author Charlène
 */

 @Component
public class StateSystemController implements Initializable {

    @FXML
    private AnchorPane StateSystemAnchorPane;
    @FXML
    private TextArea stateSystem_ReturnStateServer_Label;
    @FXML
    private TextArea StateSystem_ReturnStateBDD_Label;
    @FXML
    private TextArea stateSystem_ReturnStateApi_Label;
    @FXML
    private Button Back_Button;

     @Autowired
     StateSystemServices stateSystemServices;
     @Autowired
     Navigation navigation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//Set les labels via notre stateSystemServices

        try {
            stateSystem_ReturnStateServer_Label.setText(feedLabelServer());
            stateSystem_ReturnStateApi_Label.setText(feedLabelSystem());
            StateSystem_ReturnStateBDD_Label.setText(feedLabelDB());
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public String feedLabelServer() throws IOException {
        return stateSystemServices.giveJvmHealth();
    }

    public String feedLabelSystem() throws IOException {
        return stateSystemServices.giveHealth();
    }

    public String feedLabelDB() throws IOException {
        return stateSystemServices.giveDBHealth();
    }
    
}
