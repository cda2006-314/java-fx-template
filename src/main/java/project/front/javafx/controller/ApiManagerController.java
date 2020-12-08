package project.front.javafx.controller;

import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;
import com.aquafx_project.controls.skin.styles.TextFieldType;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.model.Api;
import project.back.back.services.ApiManageServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

import java.io.File;
import java.io.FileNotFoundException;
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
    @FXML
    private TextArea api_GiveDescription_TXTArea;
    @FXML
    private TextField api_DropFiles_TxtField;
    @FXML
    private Button apiManager_Directory_Button;

   /* @FXML
    private AnchorPane testButton;*/
private MyApiViewService service = new MyApiViewService();

    @Autowired ApiManageServices apiManageServices;

@Autowired
    Navigation navigation;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(Thread.currentThread());

        //initialise la liste des Api
        apiManage_listAPI_CB.setItems(giveList());


        //Habillage de la scène avec AquaFX
        AquaFx.createTextFieldStyler().setType(TextFieldType.ROUND_RECT).style(apiManage_create_TXT);
        AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(apiManage_CreateAPI_Button);
        AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(apiManager_Directory_Button);
        AquaFx.createButtonStyler().setIcon(MacOSDefaultIcons.LEFT).setType(ButtonType.LEFT_PILL).style(Back_Button);
        //test
       // testButton.getChildren().add(new BackButton());
        //
        //fin test
        apiManage_CreateAPI_Button.setOnAction((ActionEvent event) -> {
        createApi();
        apiManage_listAPI_CB.setItems(giveList());
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

        apiManager_Directory_Button.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(//
                    new FileChooser.ExtensionFilter("*", "*.*"),
                    new FileChooser.ExtensionFilter("json", "*.json"),
                    new FileChooser.ExtensionFilter("zip", "*.zip"),
                    new FileChooser.ExtensionFilter("CSV", "*.csv"));


            File selectedDirectory = fileChooser.showOpenDialog(apiManager_Directory_Button.getContextMenu());
            String fileUrl = selectedDirectory.getAbsolutePath();
            api_DropFiles_TxtField.setText(fileUrl);


        });

    }

    public void createApi(){


        String label = apiManage_create_TXT.getText();
        String description = api_GiveDescription_TXTArea.getText();
        String contenu = api_DropFiles_TxtField.getText();

        apiManageServices.createApi(label,description, contenu);
    }

    public ObservableList<Api> giveList(){
        List listPrep =  apiManageServices.listApi();
        ObservableList list = (ObservableList) FXCollections.observableArrayList(listPrep);
        return list;
    }



    private static class MyApiViewService extends Service<ObservableList<Api>> {
        @Autowired
        ApiManageServices apiManageServices;

        @Override
        protected Task<ObservableList<Api>> createTask() {
            return new Task<ObservableList<Api>>() {
                @Override
                protected ObservableList<Api> call() throws Exception {
                    List listPrep =  apiManageServices.listApi();
                    ObservableList<Api> observableList =  (ObservableList)  FXCollections.observableArrayList(listPrep);


                    return observableList;
                }
            };
        }


    }



}
