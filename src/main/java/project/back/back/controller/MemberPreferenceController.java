package project.back.back.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import project.back.back.model.MemberPreferences;
import project.back.back.model.Preference;
import project.back.back.services.MemberPreferencesServices;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/admin")
public class MemberPreferenceController {

    @Autowired
    MemberPreferencesServices memberPreferencesServices;

    @GetMapping("/getPreferenceMember/{memberId}")
    @ApiOperation(value="Search Preference by our memberId on our database", response = Preference.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<Preference> getPreferenceToMember(@PathVariable("memberId") int memberId){
        Preference preferenceMember = memberPreferencesServices.findByMemberId(memberId);
        if(preferenceMember != null){
            return new ResponseEntity<Preference>(preferenceMember, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/addPreference/{memberId}", method = RequestMethod.POST, produces = "application/json")
public ResponseEntity<String> addPreferencetoMember(@PathVariable("memberId") int memberId, @RequestBody int preferenceId){
        MemberPreferences memberPreferences = new MemberPreferences();
       String insertion = memberPreferencesServices.createPreferenceToMember(memberId, preferenceId);

            return new ResponseEntity<String>(insertion, HttpStatus.OK);

    }
}
