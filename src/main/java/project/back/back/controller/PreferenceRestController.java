package project.back.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.back.back.model.Picture;
import project.back.back.model.Preference;
import project.back.back.services.PictureServices;
import project.back.back.services.PreferenceServices;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class PreferenceRestController {

    @Autowired
    PreferenceServices preferenceServices;

    @GetMapping("/allPreference")
    public String apiList(){
        List<Preference> list = preferenceServices.preferenceList();

        return "List"  + list ;

    }
}
