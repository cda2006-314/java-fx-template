package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.MemberReportsEvent;

public interface MemberReportsEventRepository extends JpaRepository<MemberReportsEvent, Integer> {
}
