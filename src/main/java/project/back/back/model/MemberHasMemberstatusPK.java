package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MemberHasMemberstatusPK implements Serializable {
    private int memberId;
    private int memberstatusId;

    @Column(name = "MEMBER_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Column(name = "MEMBERSTATUS_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getMemberstatusId() {
        return memberstatusId;
    }

    public void setMemberstatusId(int memberstatusId) {
        this.memberstatusId = memberstatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberHasMemberstatusPK that = (MemberHasMemberstatusPK) o;
        return memberId == that.memberId &&
                memberstatusId == that.memberstatusId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberstatusId);
    }
}
