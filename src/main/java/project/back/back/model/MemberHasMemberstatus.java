package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_HAS_MEMBERSTATUS", schema = "dbo" )
@IdClass(MemberHasMemberstatusPK.class)
public class MemberHasMemberstatus {
    private int memberId;
    private int memberstatusId;
    private Timestamp memberHasMemberstatusDate;

    @Id
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Id
    @Column(name = "MEMBERSTATUS_ID", nullable = false, precision = 0)
    public int getMemberstatusId() {
        return memberstatusId;
    }

    public void setMemberstatusId(int memberstatusId) {
        this.memberstatusId = memberstatusId;
    }

    @Basic
    @Column(name = "MEMBER_HAS_MEMBERSTATUS_DATE", nullable = false)
    public Timestamp getMemberHasMemberstatusDate() {
        return memberHasMemberstatusDate;
    }

    public void setMemberHasMemberstatusDate(Timestamp memberHasMemberstatusDate) {
        this.memberHasMemberstatusDate = memberHasMemberstatusDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberHasMemberstatus that = (MemberHasMemberstatus) o;
        return memberId == that.memberId &&
                memberstatusId == that.memberstatusId &&
                Objects.equals(memberHasMemberstatusDate, that.memberHasMemberstatusDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberstatusId, memberHasMemberstatusDate);
    }
}
