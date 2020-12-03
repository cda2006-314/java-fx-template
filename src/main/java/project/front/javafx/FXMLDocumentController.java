
package project.front.javafx;


import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.front.javafx.controller.ToggleSwitch;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charlène
 */

@Component
// Please dont move this Controller around unless you know what you're doing
public class FXMLDocumentController implements Initializable {


    private Label label;
    @FXML
    private Label labelU;

    @FXML
    private Label labelD;
    @FXML
    private Label labelDD;

    @FXML
    private Button main_AccountAdmin_Button;
    @FXML
    private Button main_Config_Button;
    @FXML
    private Button main_StateSystem_Button;
    @FXML
    private Button main_Log_Button;
    @FXML
    private Button main_User_Button;
    @FXML
    private Button main_Group_Button;
    @FXML
    private Button main_WaitingValidate_Button;
    @FXML
    private Button main_Api_Button;
    @FXML
    private Button main_Fonts_Button;
    @FXML
    private Button main_Image_Button;
    @FXML
    private Button main_Page_Button;
    @FXML
    private Button main_Preference_Button;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private HBox all_Received_TB_HB;


@Autowired
Navigation navigation;
    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleSwitch toggleSwitch = new ToggleSwitch();

        all_Received_TB_HB.getChildren().add(toggleSwitch);

        AquaFx.createLabelStyler().setSizeVariant(ControlSizeVariant.REGULAR).style(labelD);
        AquaFx.createLabelStyler().setSizeVariant(ControlSizeVariant.REGULAR).style(labelDD);
        AquaFx.createLabelStyler().setSizeVariant(ControlSizeVariant.REGULAR).style(labelU);


        //Admin
        ImageView accountAdminImg = new ImageView(getClass().getResource("IMG/user.png").toString());
        accountAdminImg.setFitHeight(50);
        accountAdminImg.setFitWidth(50);
        ImageView configAdminImg = new ImageView(getClass().getResource("IMG/settings.png").toString());
        configAdminImg.setFitHeight(50);
        configAdminImg.setFitWidth(50);
        ImageView stateSystemImg = new ImageView(getClass().getResource("IMG/system.png").toString());
        stateSystemImg.setFitHeight(50);
        stateSystemImg.setFitWidth(50);

        ImageView logImg = new ImageView(getClass().getResource("IMG/journal.png").toString());
        logImg.setFitHeight(50);
        logImg.setFitWidth(50);
        //User
        ImageView accountUserImg = new ImageView(getClass().getResource("IMG/user.png").toString());
        accountUserImg.setFitHeight(50);
        accountUserImg.setFitWidth(50);
        ImageView manageGroupImg = new ImageView(getClass().getResource("IMG/group.png").toString());
        manageGroupImg.setFitHeight(50);
        manageGroupImg.setFitWidth(50);
        ImageView listUserImg = new ImageView(getClass().getResource("IMG/clipboard.png").toString());
        listUserImg.setFitHeight(50);
        listUserImg.setFitWidth(50);

        //Website
        ImageView apiImg = new ImageView(getClass().getResource("IMG/api.png").toString());
        apiImg.setFitHeight(50);
        apiImg.setFitWidth(50);
        ImageView fontsImg = new ImageView(getClass().getResource("IMG/font.png").toString());
        fontsImg.setFitHeight(50);
        fontsImg.setFitWidth(50);
        ImageView imagesImg = new ImageView(getClass().getResource("IMG/image.png").toString());
        imagesImg.setFitHeight(50);
        imagesImg.setFitWidth(50);
        ImageView pageImg = new ImageView(getClass().getResource("IMG/pages.png").toString());
        pageImg.setFitHeight(50);
        pageImg.setFitWidth(50);
        ImageView prefImg = new ImageView(getClass().getResource("IMG/loupe.png").toString());
        prefImg.setFitHeight(50);
        prefImg.setFitWidth(50);

        //Attribution boutons et des actions au travers de notre bean : Navigation et de se méthode showView
        //Cette méthode permet d'associer les vues au controller : essentiel pour le binding avec Spring

        main_Preference_Button.setOnAction((ActionEvent event) -> {

            Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
            navigation.setStage(stage);
            navigation.showWebSiteManagerView();

        });




        Button accountAdmin = (Button) main_AccountAdmin_Button;
       main_AccountAdmin_Button.setOnAction((ActionEvent event) -> {

                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showManageAccountView();


        });
        Button configAdmin = (Button) main_Config_Button;
        main_Config_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showConfigAdminView();


            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button stateSystemAdmin = (Button) main_StateSystem_Button;
        main_StateSystem_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showStateSystemView();


            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button logAdmin = (Button) main_Log_Button;
        main_Log_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showLogsView();


            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Attribution des images

        accountAdmin.setGraphic(accountAdminImg);
        configAdmin.setGraphic(configAdminImg);
        stateSystemAdmin.setGraphic(stateSystemImg);
        logAdmin.setGraphic(logImg);
        main_Preference_Button.setGraphic(prefImg);

        //Attribution des actions sur les boutons

        Button userAdmin = (Button) main_User_Button;
        main_User_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showUserSceneView();


            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button groupAdmin = (Button) main_Group_Button;
        main_Group_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showGroupSceneView();


            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button pendingValidateAdmin = (Button) main_WaitingValidate_Button;
        main_WaitingValidate_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showModerateManageView();

            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //Attribution des images
        userAdmin.setGraphic(accountUserImg);
        groupAdmin.setGraphic(manageGroupImg);
        pendingValidateAdmin.setGraphic(listUserImg);

        Button apiAdmin = (Button) main_Api_Button;
        main_Api_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showAPIManagerView();


            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button fontsAdmin = (Button) main_Fonts_Button;
        main_Fonts_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showFontManagerView();

            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button imageAdmin = (Button) main_Image_Button;
        main_Image_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showPictureManagerView();


            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button pageAdmin = (Button) main_Page_Button;
        main_Page_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showWebContentView();


            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //Attribution des images
        apiAdmin.setGraphic(apiImg);
        fontsAdmin.setGraphic(fontsImg);
        imageAdmin.setGraphic(imagesImg);
        pageAdmin.setGraphic(pageImg);

    }
    
    

}
