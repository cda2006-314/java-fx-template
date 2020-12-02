package project.back.back.services;

import org.springframework.stereotype.Service;
import project.back.back.controller.HealthSystemController;

import java.io.IOException;

@Service
public class StateSystemServices {

    private HealthSystemController healthSystemController = new HealthSystemController();

    public String giveHealth() throws IOException {

        return healthSystemController.getHealth();

    }

    public String giveDBHealth() throws IOException {
        return healthSystemController.getDbHealth();
    }

    public String giveJvmHealth() throws IOException {
        return healthSystemController.getJvmHealth();
    }
}
