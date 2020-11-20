 package project.front.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.model.EmployeeModeratesMember;
import project.back.back.model.MemberReportsComment;
import project.back.back.model.MemberReportsEvent;
import project.back.back.services.MemberReportsEventServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

 /**
 * FXML Controller class
 *
 * @author Charlène
 */

 @Component
public class ModerateManegeMainController implements Initializable {

     //Typage des tableaux

    @FXML
    private TableView<MemberReportsEvent> moderate_EventToModerate_Table;
    @FXML
    private TableView<MemberReportsComment> moderate_CommentsToModerate_Table;
    @FXML
    private TableView<EmployeeModeratesMember> moderate_UsersToModerate_Table;
    @FXML
    private TableView<?> moderate_AccountToValidate_Table;

     @FXML
     private TableColumn moderate_EventToModerate_TableColumn1;
     @FXML
     private TableColumn moderate_EventToModerate_TableColumn2;
     @FXML
     private TableColumn moderate_EventToModerate_TableColumn3;
     @FXML
     private TableColumn moderate_EventToModerate_TableColumn4;
     @FXML
     private TableColumn  moderate_EventToModerate_TableColumn5;



    @FXML
    private Button Back_Button;

     @Autowired
     MemberReportsEventServices memberReportsEventServices;
     @Autowired
     Navigation navigation;

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//Peuplement tableau
        //MemberReportsEvent
        moderate_EventToModerate_TableColumn1.setCellValueFactory(new PropertyValueFactory<>("eventId"));
        moderate_EventToModerate_TableColumn2.setCellValueFactory(new PropertyValueFactory<>("eventByEventId"));
        moderate_EventToModerate_TableColumn3.setCellValueFactory(new PropertyValueFactory<>("memberByMemberId"));
        moderate_EventToModerate_TableColumn4.setCellValueFactory(new PropertyValueFactory<>("memberReportsEventDate"));
        moderate_EventToModerate_TableColumn5.setCellValueFactory(new PropertyValueFactory<>("memberReportsEventPostIt"));

        //Construction de notre liste de peuplement
        ObservableList<MemberReportsEvent> listReportsEvent = listReportsEvent();
        moderate_EventToModerate_Table.setItems(listReportsEvent);

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

     private ObservableList<MemberReportsEvent> listReportsEvent() {

        ObservableList<MemberReportsEvent> listReportsEvent = FXCollections.observableArrayList(memberReportsEventServices.reportsEventList());
        return listReportsEvent;
     }

 }
