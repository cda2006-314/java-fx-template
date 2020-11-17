package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.back.back.model.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Integer> {

public static final String INVITATION_STATUS = "Select INVITATION_ISACCEPTED from Invitation i where i.INVITATION_ID = ? ";

    @Query(value = INVITATION_STATUS, nativeQuery = true)
    public int findStatus(int invitId);
}
