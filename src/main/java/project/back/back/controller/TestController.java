package project.back.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.back.back.model.Api;
import project.back.back.model.Member;
import project.back.back.model.Team;
import project.back.back.services.ApiManageServices;
import project.back.back.services.MemberServices;
import project.back.back.services.TeamServices;

import java.util.List;

/**
 * Temporary - Only for testing purposes
 * ***************************
 *  Kevin test hors contexte *
 * ***************************
 */




@RestController
public class TestController {

    @Autowired
    TeamServices teamServices;
    @Autowired
    MemberServices memberServices;

    @Autowired
    ApiManageServices apiManageServices;
/*
    @GetMapping("/allApi")
    public String apiList(){
        List<Api> list = apiManageServices.listApi();

        return "List"  + list ;

    }*/

    @GetMapping("/test")
    public String testTeam(){

        Member member = memberServices.getById(1);

      //  System.out.println("Testing team");
        Team team = new Team();
        team.setMemberId(1);
        team.setTeamLabel("team_test");
        team.setTeamPicurl("urltest");
        team.setMemberByMemberId(member);
        teamServices.create(team);

     //   System.out.println("Member "+member.getMemberUsername()+" has "+member.getTeamsByMemberId().size()+" groups : <br><br>"+teamServices.getAll());
        return "Member "+member.getMemberUsername()+" has "+member.getTeamsByMemberId().size()+" groups : <br><br>"+teamServices.getAll();
    }
}
