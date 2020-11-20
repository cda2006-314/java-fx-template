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
import project.back.back.model.Member;
import project.back.back.services.EmployeeServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

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
     TableColumn <Employee, Integer> config_returnSearchAdmin_TableColumn2;
     @FXML
     private TableColumn <Employee, Integer> config_returnSearchAdmin_TableColumn1;

    @FXML
    private AnchorPane configuration_AnchorPane;
    @FXML
    private TextField config_SearchAdmin_TxtField;
    @FXML
    private Button config_CreateAdmin_Button;
    @FXML
    private Button Back_Button;


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
        AquaFx.createTextFieldStyler().setType(TextFieldType.SEARCH).style(config_SearchAdmin_TxtField);
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

     private ObservableList<Employee> listEmployee() {
         ObservableList<Employee> listTable = FXCollections.observableArrayList(employeeServices.getList());
     return listTable; }

 }
