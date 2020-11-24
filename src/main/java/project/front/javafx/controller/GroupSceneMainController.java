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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.model.Employee;
import project.back.back.model.Team;
import project.back.back.services.TeamServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

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
     private TableColumn group_AllGroup_TableColumn3;
     @FXML
     private TableColumn group_AllGroup_TableColumn4;

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
     private TableView<Team> group_AllGroup_Table;
     @FXML
     private Button Back_Button;


     @Autowired
     TeamServices teamServices;
     @Autowired
     Navigation navigation;

     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {


         //Peuplement du tableau

         group_AllGroup_TableColumn1.setCellValueFactory(new PropertyValueFactory<>("teamId"));
         group_AllGroup_TableColumn2.setCellValueFactory(new PropertyValueFactory<>("teamLabel"));
         group_AllGroup_TableColumn3.setCellValueFactory(new PropertyValueFactory<>("teamDescription"));
         group_AllGroup_TableColumn4.setCellValueFactory(new PropertyValueFactory<>("teamPicurl"));

         //Construction de notre liste de peuplement
         ObservableList<Team> listTeam = listTeam();
         group_AllGroup_Table.setItems(listTeam);


         AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(group_Search_Button);

         AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(group_SearchByName_TxtField);
         AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(group_SearchById_TxtField);
         AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(group_SearchByKeyWords_TxtField);
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


         group_Search_Button.setOnAction((ActionEvent event) -> {
doSearchGroup();
         });
     }
     //Action bouton recherche

     private ObservableList<Team> listTeam() {
         ObservableList<Team> listTeam = FXCollections.observableArrayList(teamServices.getAll());
         return listTeam;
     }

     //retourne le tableau avec les résultats de la recherche
     public void doSearchGroup() {
         String id = group_SearchById_TxtField.getText();
         String name = group_SearchByName_TxtField.getText();
         String descriptors = group_SearchByKeyWords_TxtField.getText();

         if (!id.isEmpty()) {
             int idSearch = Integer.parseInt(id);
            Team team = teamServices.findById(idSearch);

             ObservableList<Team> listTeam = FXCollections.observableArrayList();
             listTeam.add(team);
             group_AllGroup_Table.setItems(listTeam);
         } else if (!name.isEmpty()) {
             Team team =  teamServices.findByName(name);

             ObservableList<Team> listTeam = FXCollections.observableArrayList();
             listTeam.add(team);
             group_AllGroup_Table.setItems(listTeam);

         } else if (!descriptors.isEmpty()) {
             Team team =  teamServices.findByKeywords(descriptors);
             ObservableList<Team> listTeam = FXCollections.observableArrayList();
             listTeam.add(team);
             group_AllGroup_Table.setItems(listTeam);


         }
     }
 }
