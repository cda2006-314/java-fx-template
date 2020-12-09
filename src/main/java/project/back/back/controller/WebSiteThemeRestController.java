package project.back.back.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.back.back.model.*;
import project.back.back.services.MemberHasPreferencesService;
import project.back.back.services.WebSiteThemeServices;
import project.back.back.services.WebSitethemeHasApiServices;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/admin")
public class WebSiteThemeRestController {

    @Autowired
    WebSitethemeHasApiServices websSitethemeHasApiServices;
    @Autowired
    WebSiteThemeServices webSiteThemeServices;
    @Autowired
    MemberHasPreferencesService memberHasPreferencesService;

    @GetMapping("/preferenceByMemberId/{memberId}")
    @ApiOperation(value="Search PreferenceId of a member in our database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<List<MemberHasPreferences>> getPreferenceByMemberId(@PathVariable("memberId") int memberId){
    List<MemberHasPreferences> listPreference = memberHasPreferencesService.listMemberPreferences(memberId);
    if(listPreference != null){
        return new ResponseEntity<List<MemberHasPreferences>>(listPreference, HttpStatus.OK);
    }
        return new ResponseEntity<List<MemberHasPreferences>>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/allWebsiteTheme")
    @ApiOperation(value="Search Theme on our database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<List<Websitetheme>> getList(){
        List<Websitetheme> list = webSiteThemeServices.listWebsiteTheme();
        if(list != null){
            return new ResponseEntity<List<Websitetheme>>(list, HttpStatus.OK);
        }
        return new ResponseEntity<List<Websitetheme>>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/allApiWebsiteTheme/{wbId}")
    @ApiOperation(value="Search Theme on our database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<List<Integer>> getApiList(@PathVariable("wbId") int id){
        List<Integer> list = websSitethemeHasApiServices.giveApiId(id);
        if(list != null){
            return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
        }
        return new ResponseEntity<List<Integer>>(HttpStatus.NO_CONTENT);
    }
}
