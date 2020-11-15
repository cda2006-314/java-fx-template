package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Api;

public interface ApiRepository extends JpaRepository<Api, Integer> {
}
