package project.front.javafx;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.front.javafx.controller.*;

import java.io.IOException;


@Component
public class Navigation {
    private static final Logger LOG = LoggerFactory.getLogger(Navigation.class);
    private static final String FXMLDOCUMENT_VIEW = "FXMLDocument.fxml";
    private static final String APIManager_VIEW = "views/ApiManager.fxml";
    private static final String ConfigAdmin_VIEW = "views/ConfigAdmin.fxml";
    private static final String ConfigCreateAdmin_VIEW = "views/ConfigCreateAdmin.fxml";
    private static final String FontManager_VIEW ="views/FontManager.fxml";
    private static final String GroupSceneMain_VIEW ="views/GroupSceneMain.fxml";
    private static final String GroupTheResults_VIEW ="views/GroupTheResults.fxml";
    private static final String Logs_VIEW ="views/Logs.fxml";
    private static final String ManageAccount_VIEW ="views/ManageAccount.fxml";
    private static final String ManagePassword_VIEW ="views/ManagePassword.fxml";
    private static final String ModerateManageMain_VIEW = "views/ModerateManegeMain.fxml";
    private static final String StateSystem_VIEW= "views/StateSystem.fxml";
    private static final String UserSceneMain_VIEW= "views/UserSceneMain.fxml";
    private static final String UserTheResults_VIEW= "views/UserTheResults.fxml";
    private static final String WebSiteManage_VIEW = "views/WebSiteManage.fxml";
    private Stage stage;

    @Autowired
    FXMLDocumentController fxmlDocumentController;
    @Autowired
    ApiManagerController apiManagerController;
    @Autowired
    ConfigAdminController configAdminController;
    @Autowired
    ConfigCreateAdminController configCreateAdminController;
    @Autowired
    FontManagerController fontManagerController;
    @Autowired
    GroupSceneMainController groupSceneMainController;
    @Autowired GroupTheResultsController groupTheResultsController;
    @Autowired
    LogsController logsController;
    @Autowired ManageAccountController manageAccountController;
    @Autowired ManagePasswordController managePasswordController;
    @Autowired ModerateManegeMainController moderateManegeMainController;
    @Autowired StateSystemController stateSystemController;
   @Autowired UserSceneMainController userSceneMainController;
    @Autowired UserTheResultsController userTheResultsController;
    @Autowired WebSiteManageController webSiteManageController;

   //Méthode d'affichage des views FXML

    public void showWelcomeView() {
        show(FXMLDOCUMENT_VIEW);
    }
    public void showAPIManagerView() {
        show(APIManager_VIEW);
    }
    public void showConfigAdminView(){show(ConfigAdmin_VIEW);}
    public void showConfigCreateView(){show(ConfigCreateAdmin_VIEW);}
    public void showFontManagerView(){show(FontManager_VIEW);}
    public void showGroupSceneView(){show(GroupSceneMain_VIEW);}
    public void showGroupResultsView(){show(GroupTheResults_VIEW);}
    public void showLogsView(){show(Logs_VIEW);}
    public void showManageAccountView(){show(ManageAccount_VIEW);}
    public void showManagePasswordView(){show(ManagePassword_VIEW);}
    public void showModerateManageView(){show(ModerateManageMain_VIEW);}
    public void showStateSystemView(){show(StateSystem_VIEW);}
    public void showUserSceneView(){show(UserSceneMain_VIEW);}
    public void showUserResultsView(){show(UserTheResults_VIEW);}
    public void showWebSiteManagerView(){show(WebSiteManage_VIEW);}


    private void show(String view) {
        Scene scene = new Scene(loadFxml(view));
        stage.setScene(scene);
        stage.show();
    }
    private Parent loadFxml(String view) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
        loader.setControllerFactory(param -> getViewController(view));
        try {
            loader.load();
        } catch (IOException ex) {
            LOG.error("IOException while loading resource {}: ", view, ex);
        }
        Parent root = loader.getRoot();

        return root;
    }
    private Object getViewController(String view) {
//Association des vues et de leurs controllers
        switch (view) {

            case APIManager_VIEW:   return apiManagerController;
            case ConfigAdmin_VIEW:   return configAdminController;
            case ConfigCreateAdmin_VIEW:   return configCreateAdminController;
            case FontManager_VIEW: return fontManagerController;
            case GroupSceneMain_VIEW: return groupSceneMainController;
            case GroupTheResults_VIEW: return groupTheResultsController;
            case Logs_VIEW: return logsController;
            case ManageAccount_VIEW: return manageAccountController;
            case ManagePassword_VIEW: return managePasswordController;
            case ModerateManageMain_VIEW: return moderateManegeMainController;
            case StateSystem_VIEW: return stateSystemController;
            case UserSceneMain_VIEW: return userSceneMainController;
            case UserTheResults_VIEW: return userTheResultsController;
            case WebSiteManage_VIEW: return webSiteManageController;


            default:
                return fxmlDocumentController;
        }

    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
