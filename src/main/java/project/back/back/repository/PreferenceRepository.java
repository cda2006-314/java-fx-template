package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Preference;

public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
}
