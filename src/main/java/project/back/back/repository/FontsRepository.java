package project.back.back.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Fonts;

public interface FontsRepository extends JpaRepository<Fonts, Integer> {
}

