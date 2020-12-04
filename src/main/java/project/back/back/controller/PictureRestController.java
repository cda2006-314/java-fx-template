package project.back.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.back.back.model.Api;
import project.back.back.model.Picture;
import project.back.back.services.PictureServices;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class PictureRestController {

    @Autowired
    PictureServices pictureServices;

    @GetMapping("/allPicture")
    public String apiList(){
        List<Picture> list = pictureServices.pictureList();

        return "List"  + list ;

    }
}
