package project.back.back.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ApiOperation(value="Search Picture on our database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<List<Preference>> preferenceList(){
        List<Preference> list = preferenceServices.preferenceList();
        if(list != null) {

            return new ResponseEntity<List<Preference>>(list, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<List<Preference>>(HttpStatus.NO_CONTENT);
    }

    }

