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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.model.Employee;
import project.back.back.services.EmployeeServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

 /**
 * FXML Controller class
 *
 * @author Charlène
 */

 @Component
public class ConfigCreateAdminController implements Initializable {

    @FXML
    private TextField configure_LoginNewAdmin_TxtField;
    @FXML
    private TextField configure_NewAdminPassword_Textfield;
    @FXML
    private Button configure_CreateAdmin_Button;
    @FXML
    private Button Back_Button;


     @Autowired
     Navigation navigation;
     @Autowired
     EmployeeServices employeeServices;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        AquaFx.createTextFieldStyler().setType(TextFieldType.ROUND_RECT).style(configure_NewAdminPassword_Textfield);
        AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(configure_CreateAdmin_Button);
        AquaFx.createTextFieldStyler().setType(TextFieldType.ROUND_RECT).style(configure_LoginNewAdmin_TxtField);

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

        //Création employé

        configure_CreateAdmin_Button.setOnAction((ActionEvent event) -> {
            try {
                Employee employee = new Employee();
                String login = configure_LoginNewAdmin_TxtField.getText();
                String password = configure_NewAdminPassword_Textfield.getText();

                employee.setEmployeeLogin(login);
                employee.setEmployeePassword(password);

                employeeServices.createEmployee(employee);

            }catch (Exception exception){
                Logger.getLogger(ConfigCreateAdminController.class.getName()).log(Level.SEVERE, "création impossible", exception);
            }
        });
    }    
    
}
