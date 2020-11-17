package project.front.javafx;

import com.aquafx_project.AquaFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;


/**
 *
 * @author Charlène
 */
// Run the app
@SpringBootApplication
public class JavaFXApplication extends Application {

    @Autowired
    private Navigation navigation;
    private ConfigurableApplicationContext applicationContext;
    Parent root;


    public static void main(String[] args) {
        Application.launch();
    }
    @Override
    public void init() throws IOException {

        SpringApplication.run(getClass()).getAutowireCapableBeanFactory().autowireBean(this);

    }

    @Override
    public void start(Stage stage) throws Exception {
        AquaFx.style();
        AquaFx.styleStage(stage, StageStyle.UNIFIED);

        navigation.setStage(stage);
        navigation.showWelcomeView();
    }


    /**
     * Main method to run JavaFX App
     **/

    public static void run(String[] args){
        launch(args);
    }
}
