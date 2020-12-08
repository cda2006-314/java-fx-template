 package project.front.javafx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.model.Api;
import project.back.back.model.Fonts;
import project.back.back.model.Picture;
import project.back.back.model.Webcontent;
import project.back.back.services.ApiManageServices;
import project.back.back.services.FontsServices;
import project.back.back.services.PictureServices;
import project.back.back.services.WebContentServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

 /**
 * FXML Controller class
 *
 * @author Charlène
 */

 @Component
public class WebSiteManageController implements Initializable {

    @FXML
    private ComboBox<Api> ManageWebSite_ShowApi_CB;
    @FXML
    private ComboBox<Fonts> ManageWebSite_ShowFont_CB;
    @FXML
    private ComboBox<Picture> ManageWebSite_ShowImages_CB;
    @FXML
    private ComboBox<Webcontent> ManageWebSite_ShowPages_CB;
    @FXML
    private TreeView<?> ManageWebSite_AssocPreference_TreeView;
    @FXML
    private Button Back_Button;


     @Autowired
     Navigation navigation;

     @Autowired
     FontsServices fontsServices;
     @Autowired
     ApiManageServices apiManageServices;
     @Autowired
     PictureServices pictureServices;
     @Autowired
     WebContentServices webContentServices;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {



        //ManageWebSite_ShowApi_CB
        ManageWebSite_ShowApi_CB.setItems(showApi());

        //ManageWebSite_ShowFont_CB
        ManageWebSite_ShowFont_CB.setItems(showFonts());

        //ManageWebSite_ShowImages_CB
        ManageWebSite_ShowImages_CB.setItems(showPictures());

        //ManageWebSite_ShowPages_CB
        ManageWebSite_ShowPages_CB.setItems(showWebContent());

        AquaFx.createComboBoxStyler().style(ManageWebSite_ShowPages_CB);
        AquaFx.createComboBoxStyler().style(ManageWebSite_ShowImages_CB);
        AquaFx.createComboBoxStyler().style(ManageWebSite_ShowFont_CB);
        AquaFx.createComboBoxStyler().style(ManageWebSite_ShowApi_CB);
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

    public ObservableList<Api> showApi(){  List listPrep = apiManageServices.listApi();
        ObservableList list =  FXCollections.observableArrayList(listPrep);
    return list;}

    public ObservableList<Fonts> showFonts(){
        List listPrepa = (List) fontsServices.fontsList();
        ObservableList lista =  FXCollections.observableArrayList(listPrepa);
        return lista;
    }

    public ObservableList<Picture> showPictures(){
        List listPrepar = (List) pictureServices.pictureList();
        ObservableList listar = FXCollections.observableArrayList(listPrepar);
        return listar;
    }

    public ObservableList<Webcontent> showWebContent(){
        List prepaContent = webContentServices.webcontentList();
        ObservableList<Webcontent> listContent = FXCollections.observableArrayList(prepaContent);
        return listContent;

    }
    
}
