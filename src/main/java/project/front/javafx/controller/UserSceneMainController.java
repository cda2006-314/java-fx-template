 package project.front.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;
import com.aquafx_project.controls.skin.styles.TextFieldType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.back.back.services.EmployeeServices;
import project.back.back.services.MemberServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

 /**
 * FXML Controller class
 *
 * @author Charlène
 */

 @Controller
public class UserSceneMainController implements Initializable {
@FXML
private TableColumn user_AllUsers_TableColumn1;
@FXML
private TableColumn user_AllUsers_TableColumn2;
    @FXML
    private Button user_SearchUser_Button;
    @FXML
    private TextField user_SearchLogin_TextField;
    @FXML
    private TextField user_SearchEvent_Textfield;
    @FXML
    private ComboBox<?> user_SearchStatus_CB;
    @FXML
    private AnchorPane user_ResultSearch_AnchorPane;
    @FXML
    private TableView<?> user_AllUsers_Table;
    @FXML
    private Button Back_Button;
     @Autowired
   private MemberServices memberServices;
     @Autowired
     private EmployeeServices employeeServices;
     @Autowired
     Navigation navigation;


  // public void setMemberServices(MemberServices memberServices){this.memberServices = memberServices;}


    /**
     * Initializes the controller class.
     */


    @Override
    public void initialize(URL url, ResourceBundle rb) {


         List listPrep = (List) memberServices.listMemberStatus();

        ObservableList list = (ObservableList) FXCollections.observableArrayList(listPrep);
        user_SearchStatus_CB.setItems(list);


        AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(user_SearchUser_Button);
        AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(user_SearchLogin_TextField);
        AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(user_SearchEvent_Textfield);
        AquaFx.createComboBoxStyler().style(user_SearchStatus_CB);

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
