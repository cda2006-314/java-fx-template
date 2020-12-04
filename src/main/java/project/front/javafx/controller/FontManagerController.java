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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.services.FontsServices;
import project.back.back.services.PictureServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
    private TextField fonts_DropFiles_TxtField;
    @FXML
    private TextField  fontManager_DropImage_TxtField;
    @FXML
    private Button fontManager_DropImage_Button;
    @FXML
    private Button fontsManager_DropFonts_Button;

@FXML
private ComboBox fontManage_return_CB;




    @Autowired
    Navigation navigation;

    @Autowired
    FontsServices fontsServices;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List listPrep = (List) fontsServices.fontsList();
        ObservableList list = (ObservableList) FXCollections.observableArrayList(listPrep);
        fontManage_return_CB.setItems(list);


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
        fontManage_CreateFont_Button.setOnAction((ActionEvent event) -> {
        createFont();
        });

        fontManager_DropImage_Button.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(//
                    new FileChooser.ExtensionFilter("*", "*.*"),
                    new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png"));


            File selectedDirectory = fileChooser.showOpenDialog(fontManager_DropImage_Button.getContextMenu());
            String fileUrl = selectedDirectory.getAbsolutePath();
            fontManager_DropImage_TxtField.setText(fileUrl);
        });

        fontsManager_DropFonts_Button.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(//
                    new FileChooser.ExtensionFilter("*", "*.*"),
                    new FileChooser.ExtensionFilter("json", "*.json"),
                    new FileChooser.ExtensionFilter("zip", "*.zip"),
                    new FileChooser.ExtensionFilter("CSV", "*.csv"));


            File selectedDirectory = fileChooser.showOpenDialog(fontManager_DropImage_Button.getContextMenu());
            String fileUrl = selectedDirectory.getAbsolutePath();
            fonts_DropFiles_TxtField.setText(fileUrl);
        });
    }

    public void createFont(){
        String label = fontManage_create_TXT.getText();
        String contenu = fonts_DropFiles_TxtField.getText();
        String image = fontManager_DropImage_TxtField.getText();

        fontsServices.createFont(label, image, contenu);

    }

}
