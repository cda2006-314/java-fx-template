
package project.front.javafx;


import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.jfoenix.controls.JFXRippler;
import com.sun.org.slf4j.internal.LoggerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

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
    private Color x4;
    @FXML
    private Font x3;

    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {


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
        //Attribution boutons 
        Button accountAdmin = (Button) main_AccountAdmin_Button;
       main_AccountAdmin_Button.setOnAction((ActionEvent event) -> {
           System.out.println("test");
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();

                Parent root = FXMLLoader.load(getClass().getResource("views/ManageAccount.fxml"));
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button configAdmin = (Button) main_Config_Button;
        main_Config_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("views/ConfigAdmin.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button stateSystemAdmin = (Button) main_StateSystem_Button;
        main_StateSystem_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("views/StateSystem.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button logAdmin = (Button) main_Log_Button;
        main_Log_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("views/Logs.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //Attribution des images

        accountAdmin.setGraphic(accountAdminImg);
        configAdmin.setGraphic(configAdminImg);
        stateSystemAdmin.setGraphic(stateSystemImg);
        logAdmin.setGraphic(logImg);

        Button userAdmin = (Button) main_User_Button;
        main_User_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("views/UserSceneMain.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button groupAdmin = (Button) main_Group_Button;
        main_Group_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("views/GroupSceneMain.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button pendingValidateAdmin = (Button) main_WaitingValidate_Button;
        main_WaitingValidate_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("views/ModerateManegeMain.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
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
                Parent root = FXMLLoader.load(getClass().getResource("views/ApiManager.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button fontsAdmin = (Button) main_Fonts_Button;
        main_Fonts_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("views/FontManager.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button imageAdmin = (Button) main_Image_Button;
        main_Image_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("views/WebSiteManage.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button pageAdmin = (Button) main_Page_Button;
        main_Image_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) main_AccountAdmin_Button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("views/WebSiteManage.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
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
