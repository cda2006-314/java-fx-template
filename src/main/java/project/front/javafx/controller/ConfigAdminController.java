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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.model.Employee;
import project.back.back.model.Member;
import project.back.back.services.EmployeeServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

 /**
 * FXML Controller class
 *
 * @author Charlène
 */

 @Component
public class ConfigAdminController implements Initializable {

     @FXML
     private TableView<Employee> config_returnSearchAdmin_Table;
     @FXML
     private
     TableColumn<Employee, Integer> config_returnSearchAdmin_TableColumn2;
     @FXML
     private TableColumn<Employee, Integer> config_returnSearchAdmin_TableColumn1;

     @FXML
     private AnchorPane configuration_AnchorPane;
     @FXML
     private TextField config_SearchAdmin_TxtField;
     @FXML
     public TextField config_SearchAdminByLogin_TxtField;
     @FXML
     private Button config_CreateAdmin_Button;
     @FXML
     private Button Back_Button;
     @FXML
     public AnchorPane config_CreateAdminReceive_AnchorPane;
     @FXML
     public Button config_SearchAdmin_Button;


     @Autowired
     EmployeeServices employeeServices;
     @Autowired
     Navigation navigation;

     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {

         //Peuplement du tableau
         config_returnSearchAdmin_TableColumn1.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
         config_returnSearchAdmin_TableColumn2.setCellValueFactory(new PropertyValueFactory<>("employeeLogin"));

         //Construction de notre liste de peuplement
         ObservableList<Employee> listEmployee = listEmployee();
         config_returnSearchAdmin_Table.setItems(listEmployee);


         AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(config_CreateAdmin_Button);
         AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(config_SearchAdmin_Button);
         AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(config_SearchAdmin_TxtField);
         AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(config_SearchAdminByLogin_TxtField);

         Button tbBack = Back_Button;
         AquaFx.createButtonStyler().setIcon(MacOSDefaultIcons.LEFT).setType(ButtonType.LEFT_PILL).style(tbBack);

         //Recherche selon login ou id
         config_SearchAdmin_Button.setOnAction((ActionEvent event) -> {
         doSearch();
                 });

         Back_Button.setOnAction((ActionEvent event) -> {
             try {
                 Stage stage = (Stage) Back_Button.getScene().getWindow();
                 navigation.setStage(stage);
                 navigation.showWelcomeView();
             } catch (Exception ex) {
                 Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
             }
         });


         config_CreateAdmin_Button.setOnAction((ActionEvent event) -> {
                      try {
                          Stage stage = (Stage) Back_Button.getScene().getWindow();
                          navigation.setStage(stage);
                          navigation.showConfigCreateView();
                     } catch (Exception ex) {
                          Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                  });
     }




     private ObservableList<Employee> listEmployee() {
         ObservableList<Employee> listTable = FXCollections.observableArrayList(employeeServices.getList());
         return listTable;
     }

     public void doSearch() {
         String id = config_SearchAdmin_TxtField.getText();
         String login = config_SearchAdminByLogin_TxtField.getText();

         if (!id.isEmpty()) {
             int idSearch = Integer.parseInt(id);
             Employee employee = employeeServices.findById(idSearch);
             ObservableList<Employee> listTable = FXCollections.observableArrayList();
             listTable.add(employee);
             config_returnSearchAdmin_Table.setItems(listTable);
         } else if (!login.isEmpty()) {
             Employee employee = employeeServices.findByLogin(login);
             ObservableList<Employee> listTable = FXCollections.observableArrayList();
             listTable.add(employee);
             config_returnSearchAdmin_Table.setItems(listTable);
         } else {
             String message = "Aucune entrée !";
         }
     }
 }
