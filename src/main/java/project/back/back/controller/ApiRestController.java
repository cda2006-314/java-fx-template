package project.back.back.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.back.back.model.Api;
import project.back.back.services.ApiManageServices;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class ApiRestController {

    @Autowired
    ApiManageServices apiManageServices;

    @GetMapping("/allApi")
    @ApiOperation(value="Search Api's on our database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<List<Api>> apiList(){
        List<Api> list = apiManageServices.listApi();
        if(list != null) {

            return new ResponseEntity<List<Api>>(list, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<List<Api>>(HttpStatus.NO_CONTENT);
    }

    /*
    @GetMapping("/get/{apiId}")
    public ResponseEntity<Api> getById(@PathVariable ("apiId") int id){

    }
      */


}
