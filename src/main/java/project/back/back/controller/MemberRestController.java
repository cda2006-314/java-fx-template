package project.back.back.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.back.back.model.Member;
import project.back.back.services.MemberServices;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/admin")
public class MemberRestController {

    @Autowired
    MemberServices memberServices;

    @GetMapping("/memberByEmail/{email}")
    @ApiOperation(value="Search Member by his email on our database", response = Member.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<Member> getMember(@PathVariable("email") String memberEmail){
    Member member = memberServices.getByEmail(memberEmail);

    if(member != null){
        return new ResponseEntity<Member>(member, HttpStatus.ACCEPTED);
    }

        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT) ;
    }

    @GetMapping("/memberByLogin/{login}")
    @ApiOperation(value="Search Member by his login on our database", response = Member.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<Member> getMemberByLogin(@PathVariable("login") String memberLogin){
        Member member = memberServices.getByLogin(memberLogin);

        if(member != null){
            return new ResponseEntity<Member>(member, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT) ;
    }
    @GetMapping("/memberIdByLogin/{login}")
    @ApiOperation(value="Search MemberId by his login on our database", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded"),
    })
    public ResponseEntity<Integer> getMemberIdByLogin(@PathVariable("login") String memberLogin){
        Member member = memberServices.getByLogin(memberLogin);
int memberId = member.getMemberId();
        if(member != null){
            return new ResponseEntity<Integer>(memberId, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT) ;
    }

}
