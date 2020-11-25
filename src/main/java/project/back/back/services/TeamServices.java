package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Team;
import project.back.back.repository.TeamRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class TeamServices {

    @Autowired
    TeamRepository teamRepository;

    public void create(Team team){
        teamRepository.save(team);
    }
    public void update(Team team){
        teamRepository.save(team);
    }
    public void getById(int id){
        teamRepository.getOne(id);
    }

    public Team findByName(String name) {
        Optional<Team> teamOptional = teamRepository.findTeamByTeamLabel(name);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            return team;
        } else {
            return null;
        }
    }

    public Team findById(int id) {
        Optional<Team> teamOptional = teamRepository.findTeamByTeamId(id);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            return team;
        } else {
            return null;
        }
    }

    public Team findByKeywords(String keywords) {
        Optional<Team> teamOptional = teamRepository.findTeamByTeamDescriptionContains(keywords);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            return team;
        } else {
            return null;
        }
    }



    public Collection<Team> getAll(){ return  teamRepository.findAll();
    }
}
