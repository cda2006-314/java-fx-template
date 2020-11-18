package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {


}
