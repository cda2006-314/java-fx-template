package project.front.javafx.controller;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.services.FontsServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class FontManagerController implements Initializable {
    @FXML
    private HTMLEditor fontManage_htmlEditor_Editor;
    @FXML
    private TextField fontManage_create_TXT;
    @FXML
    private Button fontManage_CreateFont_Button;
    @FXML
    private Button Back_Button;
@FXML
private ComboBox fontManage_return_CB;

    @Autowired
    Navigation navigation;

@Autowired
    FontsServices fontsServices;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        AquaFx.createTextFieldStyler().setType(TextFieldType.ROUND_RECT).style(fontManage_create_TXT);
        AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(fontManage_CreateFont_Button);
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
