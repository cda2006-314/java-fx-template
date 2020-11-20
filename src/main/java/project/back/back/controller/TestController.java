package project.back.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.back.back.model.Member;
import project.back.back.model.Team;
import project.back.back.services.MemberServices;
import project.back.back.services.TeamServices;

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


    @GetMapping("/test")
    public String testTeam(){

        Member member = memberServices.getById(1);

        System.out.println("Testing team");
        Team team = new Team();
        team.setMemberId(1);
        team.setTeamLabel("team_test");
        team.setTeamPicurl("urltest");
        team.setMemberByMemberId(member);
        teamServices.create(team);

        System.out.println("Member "+member.getMemberUsername()+" has "+member.getTeamsByMemberId().size()+" groups : <br><br>"+teamServices.getAll());
        return "Member "+member.getMemberUsername()+" has "+member.getTeamsByMemberId().size()+" groups : <br><br>"+teamServices.getAll();
    }
}
