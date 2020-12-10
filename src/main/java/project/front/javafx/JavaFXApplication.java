package project.front.javafx;

import com.aquafx_project.AquaFx;
import javafx.application.Application;
import javafx.scene.Parent;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;


/**
 *
 * @author Charlène
 */
// Run the app
@SpringBootApplication
@ComponentScan(basePackages = {"project.back.back.services", "project.front.javafx", "project.back.back.repository", "project.back"})
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
        // White screen issues (for some people) when this line is uncommented
        AquaFx.styleStage(stage, StageStyle.DECORATED);

        navigation.setStage(stage);
      //  navigation.showWelcomeView();
        navigation.showLogin();
    }


    /**
     * Main method to run JavaFX App
     **/

    public static void run(String[] args){
        launch(args);
    }
}
