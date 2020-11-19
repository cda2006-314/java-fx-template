 package project.front.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;
import com.aquafx_project.controls.skin.styles.TextFieldType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import project.front.javafx.FXMLDocumentController;

 /**
 * FXML Controller class
 *
 * @author Charlène
 */


 @Component
public class GroupSceneMainController implements Initializable {

     @FXML
     private TableColumn group_AllGroup_TableColumn1;
     @FXML
     private TableColumn group_AllGroup_TableColumn2;

     @FXML
    private AnchorPane group_AnchorPane;
    @FXML
    private TextField group_SearchByName_TxtField;
    @FXML
    private TextField group_SearchById_TxtField;
    @FXML
    private TextField group_SearchByKeyWords_TxtField;
    @FXML
    private Button group_Search_Button;
    @FXML
    private AnchorPane group_ReceiveResults_AnchorPane;
    @FXML
    private TableView<?> group_AllGroup_Table;
    @FXML
    private Button Back_Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(group_Search_Button);

        AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(group_SearchByName_TxtField);
        AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(group_SearchById_TxtField);
        AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(group_SearchByKeyWords_TxtField);
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
