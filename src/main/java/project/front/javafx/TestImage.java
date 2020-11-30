package project.front.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestImage  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {



        FileInputStream input = new FileInputStream("C:\\Users\\Charlène\\Downloads\\ligne-d'assemblage.png");

        Image image = new Image(input);

        ImageView imageView = new ImageView(image);


        FlowPane root = new FlowPane();
        root.setPadding(new Insets(20));

        root.getChildren().addAll(imageView);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("JavaFX ImageView (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
