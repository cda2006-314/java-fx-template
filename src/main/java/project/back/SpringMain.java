package project.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import project.front.javafx.JavaFXMain;

@SpringBootApplication
@EntityScan("project.back.back.model")
@EnableJpaRepositories("project.back.back.repository")
public class SpringMain  {

    // Runs SpringApp then JavaFX
    public static void main(String[] args) {
        SpringApplication.run(SpringMain.class, args);
        // Runs JavaFX
        //JavaFXMain.main(args);

    }
}
