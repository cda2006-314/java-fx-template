package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.back.back.model.Memberstatus;

public interface MemberstatusRepository extends JpaRepository<Memberstatus, Integer> {

    public String UPDATE_MEMBERSTATUS = "UPDATE MEMBER_HAS_MEMBERSTATUS m set MEMBER_ID where m.MEMBER_ID = ?";

    @Query(value = UPDATE_MEMBERSTATUS, nativeQuery = true)
    public void updateMemberStatus (int memberId);

}
