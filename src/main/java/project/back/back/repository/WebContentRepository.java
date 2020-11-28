package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Webcontent;

public interface WebContentRepository extends JpaRepository<Webcontent, Integer> {
}
