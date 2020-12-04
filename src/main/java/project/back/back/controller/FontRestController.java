package project.back.back.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.back.back.model.Fonts;
import project.back.back.model.Picture;
import project.back.back.services.FontsServices;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/admin")
public class FontRestController {

    @Autowired
    FontsServices fontsServices;

    @GetMapping("/allFonts")
    @ApiOperation(value="Search Picture on our database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<List<Fonts>> fontsList(){
        List<Fonts> list = fontsServices.fontsList();
        if(list != null) {

            return new ResponseEntity<List<Fonts>>(list, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<List<Fonts>>(HttpStatus.NO_CONTENT);
    }
}
