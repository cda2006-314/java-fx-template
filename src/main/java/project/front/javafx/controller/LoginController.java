package project.front.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.services.EmployeeServices;
import project.front.javafx.Navigation;


import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {
@Autowired
    EmployeeServices employeeServices;
@Autowired
    Navigation navigation;

    @FXML
   private TextField login_Txt;
   @FXML
   private TextField password_Txt;
   @FXML
   private Button login_Check_ManagerButton;
   @FXML
   private Label login_Error_Label;
static String usernameManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        login_Check_ManagerButton.setOnAction((ActionEvent event) -> {
                if(checkEmployee()){
                    Stage stage = (Stage) login_Check_ManagerButton.getScene().getWindow();
                    navigation.setStage(stage);
                    navigation.showWelcomeView();
                    usernameManager = login_Txt.getText();
                }else{
                    String erreur = "Tentative échoué. Resaisissez votre mot de passe";
                    login_Error_Label.setText(erreur);
                }
        });

    }


    public boolean checkEmployee(){
String login = login_Txt.getText();
String password = password_Txt.getText();

        return employeeServices.checkLogin(login, password);
    }
}
