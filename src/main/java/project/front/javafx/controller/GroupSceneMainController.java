 package project.front.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Charlène
 */
public class GroupSceneMainController implements Initializable {

    @FXML
    private AnchorPane group_AnchorPane;
    @FXML
    private TextField group_SearchByName_TxtField;
    @FXML
    private TextField group_SearchById_TxtField;
    @FXML
    private TextField group_SearchByKeyWords_TxtField;
    @FXML
    private Button group_Search_Button;
    @FXML
    private AnchorPane group_ReceiveResults_AnchorPane;
    @FXML
    private TableView<?> group_AllGroup_Table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
