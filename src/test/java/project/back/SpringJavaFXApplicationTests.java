package project.back;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import project.front.javafx.JavaFXApplication;
import project.front.javafx.JavaFXMain;

@SpringBootTest
class SpringJavaFXApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        JavaFXMain.main(args);
    }

}
