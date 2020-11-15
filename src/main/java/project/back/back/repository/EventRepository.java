package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
