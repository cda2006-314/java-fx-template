package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.back.back.model.Eventstatus;

public interface EventstatusRepository extends JpaRepository<Eventstatus, Integer> {

    public String UPDATE_EVENTSTATUS = "UPDATE EVENT_HAS_EVENTSTATUS u set EVENTSTATUS_ID where m.EVENT_ID = ?";

    @Query(value = UPDATE_EVENTSTATUS, nativeQuery = true)
    public void updateEventStatus (int eventId);

}
