package project.front.javafx.controller;

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
import javafx.scene.control.ComboBox;
import javafx.scene.web.HTMLEditor;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.services.ApiManageServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
public class ApiManagerController implements Initializable {

    @FXML
    private ComboBox apiManage_listAPI_CB;
    @FXML
   private HTMLEditor apiManage_htmlEditor_Editor;
    @FXML
    private TextField apiManage_create_TXT;
    @FXML
    private Button apiManage_CreateAPI_Button;
    @FXML
    private Button Back_Button;
    @Autowired ApiManageServices apiManageServices;

@Autowired
    Navigation navigation;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //initialise la liste des Api
        List listPrep = (List) apiManageServices.listApi();
        ObservableList list = (ObservableList) FXCollections.observableArrayList(listPrep);
        apiManage_listAPI_CB.setItems(list);


        //Habillage de la scène avec AquaFX
        AquaFx.createTextFieldStyler().setType(TextFieldType.ROUND_RECT).style(apiManage_create_TXT);
        AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(apiManage_CreateAPI_Button);
        AquaFx.createButtonStyler().setIcon(MacOSDefaultIcons.LEFT).setType(ButtonType.LEFT_PILL).style(Back_Button);
        Back_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) Back_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showWelcomeView();
             /*   Parent root = FXMLLoader.load(getClass().getResource("../FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();*/
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
