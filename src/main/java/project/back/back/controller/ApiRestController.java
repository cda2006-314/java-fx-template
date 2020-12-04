package project.back.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String apiList(){
        List<Api> list = apiManageServices.listApi();

        return "List"  + list ;

    }

    /*
    @GetMapping("/get/{apiId}")
    public ResponseEntity<Api> getById(@PathVariable ("apiId") int id){

    }
      */


}
