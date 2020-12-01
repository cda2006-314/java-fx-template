package project.front.javafx.controller;

import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;
import com.aquafx_project.controls.skin.styles.TextFieldType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.back.back.services.PictureServices;
import project.front.javafx.FXMLDocumentController;
import project.front.javafx.Navigation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class PictureManagerController implements Initializable {



    @FXML
    private ComboBox pictureManage_return_CB;
    @FXML
    private TextField pictureManage_create_TXT;
    @FXML
    private Button pictureManage_CreatePicture_Button;
    @FXML
    private Button Back_Button;
    @FXML
    private AnchorPane picture_ReceivePicture_AnchorPane;
    @FXML
    private Button picture_AddPicture_Button;

    @Autowired
    Navigation navigation;
    @Autowired
    PictureServices pictureServices;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List listPrep = (List) pictureServices.pictureList();
        ObservableList list = (ObservableList) FXCollections.observableArrayList(listPrep);
        pictureManage_return_CB.setItems(list);


        AquaFx.createButtonStyler().setIcon(MacOSDefaultIcons.LEFT).setType(ButtonType.LEFT_PILL).style(Back_Button);
        AquaFx.createTextFieldStyler().setType(TextFieldType.ROUND_RECT).style(pictureManage_create_TXT);
        Back_Button.setOnAction((ActionEvent event) -> {
            try {
                Stage stage = (Stage) Back_Button.getScene().getWindow();
                navigation.setStage(stage);
                navigation.showWelcomeView();
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Add images from the user home. Return a visualisation of the image in JavaFX

        pictureManage_CreatePicture_Button.setOnAction((ActionEvent event) -> {

            loadImage();


        });

        picture_AddPicture_Button.setOnAction((ActionEvent event) -> {
            String url = pictureManage_create_TXT.getText();
            System.out.println(pictureManage_create_TXT.getText());
            pictureServices.createPicture(url);
        });
    }
    public void loadImage(){
            if (pictureManage_create_TXT.isEditable()) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(//
                        new FileChooser.ExtensionFilter("*", "*.*"),
                        new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png"));

                try {
                    File selectedDirectory = fileChooser.showOpenDialog(pictureManage_CreatePicture_Button.getContextMenu());
                    String fileUrl = selectedDirectory.getAbsolutePath();
                    pictureManage_create_TXT.setText(selectedDirectory.getAbsolutePath());
                    // pictureManage_create_TXT.setDisable(true);
                    System.out.println(pictureManage_create_TXT.getText());
                    String urlImg = pictureManage_create_TXT.getText();
                    //replace all whitespaces by %
                    //check the create picture doesnt send error but doesnt work
//
//>>
                    FileInputStream input = new FileInputStream(urlImg);

                    Image image = new Image(input);

                    ImageView imageView = new ImageView(image);
/*
                    final URL imageURL = getClass().getResource(fileUrl);
                    String localUrl;
                    localUrl = imageURL.toURI().toURL().toString();
                    final ImageView imageView = new ImageView(localUrl);*/
                    picture_ReceivePicture_AnchorPane.getChildren().setAll(imageView);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            } else {

            }



        }
}

