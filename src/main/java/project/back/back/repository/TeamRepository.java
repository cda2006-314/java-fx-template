package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Team;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {
Optional<Team> findTeamByTeamLabel(String name);
Optional<Team> findTeamByTeamId(int id);
Optional<Team> findTeamByTeamDescriptionContains(String keywords);

}
