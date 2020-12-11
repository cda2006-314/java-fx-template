 package project.front.javafx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.model.*;
import project.back.back.services.*;
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
@FXML
private TextArea website_ReceiveApi_TextArea;
@FXML
private TextArea website_ReceiveFonts_TextArea;
@FXML
private TextField webManager_CreatePreference_Txt;
@FXML
private TextField website_SearchImage_Txt;
@FXML
private Button website_SearchImage_Button;
@FXML
private Button preference_Create_Button;
@FXML
private ComboBox<Preference> website_ShowPreference_Cb;

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
     @Autowired
     WebSiteThemeServices webSiteThemeServices;
     @Autowired
     PreferenceServices preferenceServices;
private List<String> apiFonts = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        website_SearchImage_Button.setOnAction((ActionEvent event) -> {
            searchImage();
        });

        /*
        preference_Create_Button.setOnAction((ActionEvent event) -> {
            createPreference();
            website_ShowPreference_Cb.setItems(showPreference());
        });*/

        preference_Create_Button.setDisable(true);
        //website_ShowPreference_Cb
        website_ShowPreference_Cb.setItems(showPreference());

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
        ObservableList list = (ObservableList) FXCollections.observableArrayList(listPrep);
    return list;}

    public ObservableList<Fonts> showFonts(){
        List listPrepa = (List) fontsServices.fontsList();
        ObservableList lista = (ObservableList) FXCollections.observableArrayList(listPrepa);
        return lista;
    }

    public ObservableList<Picture> showPictures(){
        List listPrepar = (List) pictureServices.pictureList();
        ObservableList listar = (ObservableList) FXCollections.observableArrayList(listPrepar);
        return listar;
    }

    public ObservableList<Webcontent> showWebContent(){
        List prepaContent = webContentServices.webcontentList();
        ObservableList<Webcontent> listContent = FXCollections.observableArrayList(prepaContent);
        return listContent;

    }
     public ObservableList<Preference> showPreference(){
         List prepaPref = preferenceServices.preferenceList();
         ObservableList<Preference> listPreference = FXCollections.observableArrayList(prepaPref);
         return listPreference;

     }


    @FXML
     public  void  addApi(){
        website_ReceiveApi_TextArea.setText(ManageWebSite_ShowApi_CB.getSelectionModel().getSelectedItem().toString() + "\n");

    }

    @FXML
    public void addFonts(){

        apiFonts.add(ManageWebSite_ShowFont_CB.getSelectionModel().getSelectedItem().toString());
        for (String fonts: apiFonts) {
            website_ReceiveFonts_TextArea.setText(fonts + "\n");
        }

    }
     /*
    - Méthode qui prend les cb : cb.getSelected() ==> encapsuler en string
    puis mon textArea .setText du string

    au setAction : createPreference() :
    - prendre le txtfield nom et le txt image : qui va créer ma préference
    puis un webTheme avec le txtfield nom

    - websitethemeApi : nouveau service va prendre l'id de mon webTheme créée puis crééer mon association entre
    mon api puis le websitetheme Id

    -websitetheme fonts : va faire pareil que le theme api
     */


     public void searchImage(){


         FileChooser fileChooser = new FileChooser();
         fileChooser.getExtensionFilters().addAll(//
                 new FileChooser.ExtensionFilter("*", "*.*"),
                 new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                 new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                 new FileChooser.ExtensionFilter("PNG", "*.png"));


             File selectedDirectory = fileChooser.showOpenDialog(website_SearchImage_Button.getContextMenu());
             String fileUrl = selectedDirectory.getAbsolutePath();
             website_SearchImage_Txt.setText(selectedDirectory.getAbsolutePath());


     }
     public void createPreference(){
Preference preference = new Preference();
preference.setPreferenceLabel(webManager_CreatePreference_Txt.getText());
preference.setPreferenceDescription(website_SearchImage_Txt.getText());
preference.setPreferenceDescription(webManager_CreatePreference_Txt.getText());
preference.setWebsitethemeId(1);
         preferenceServices.createPreference(preference);
     }
    
}
