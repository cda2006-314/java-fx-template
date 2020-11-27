package project.front.javafx.controller;

import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.services.WebContentServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class WebContentManagerController implements Initializable {

    @FXML
    private ComboBox pageManage_return_CB;
    @FXML
    private Button page_VisualizePage_Button;
    @FXML
    private Button Back_Button;
    @FXML
    private WebView page_WebPreview;



    @Autowired
    Navigation navigation;
    @Autowired
    WebContentServices webContentServices;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Préparation liste ComboBox
        List listPrep = (List) webContentServices.webcontentList();
        ObservableList list = (ObservableList) FXCollections.observableArrayList(listPrep);
        pageManage_return_CB.setItems(list);



        AquaFx.createButtonStyler().setType(ButtonType.ROUND_RECT).style(page_VisualizePage_Button);
        AquaFx.createButtonStyler().setIcon(MacOSDefaultIcons.LEFT).setType(ButtonType.LEFT_PILL).style(Back_Button);
        Back_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) Back_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showWelcomeView();

            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        page_VisualizePage_Button.setOnAction((ActionEvent event) -> {


            WebEngine webEngine = page_WebPreview.getEngine();
            String pageUrl = pageManage_return_CB.getValue().toString();
            System.out.println(pageUrl);
                webEngine.load(pageUrl);


        });
    }
}
