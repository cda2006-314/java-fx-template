package project.front.javafx;

import com.aquafx_project.AquaFx;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author Charlène
 */
// Do not run run() from here
public class JavaFXApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        AquaFx.style();
        AquaFx.styleStage(stage, StageStyle.UNIFIED);

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method to run JavaFX App
     *
     */
    public static void run(String[] args){
        launch(args);
    }
}
