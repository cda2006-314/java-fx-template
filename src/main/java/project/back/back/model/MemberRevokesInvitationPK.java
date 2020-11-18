package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MemberRevokesInvitationPK implements Serializable {
    private int invitationId;
    private int memberId;

    @Column(name = "INVITATION_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(int invitationId) {
        this.invitationId = invitationId;
    }

    @Column(name = "MEMBER_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberRevokesInvitationPK that = (MemberRevokesInvitationPK) o;
        return invitationId == that.invitationId &&
                memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitationId, memberId);
    }
}
