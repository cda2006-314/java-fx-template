package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
