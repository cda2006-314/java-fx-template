package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Team;
import project.back.back.repository.TeamRepository;

import java.util.Collection;

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
    public Collection<Team> getAll(){
        return teamRepository.findAll();
    }
}
