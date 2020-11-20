package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.MemberHasMemberstatus;

public interface MemberHasMemberstatusRepository extends JpaRepository<MemberHasMemberstatus, Integer> {
}
