package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_SENDS_INVITATION", schema = "dbo" )
@IdClass(MemberSendsInvitationPK.class)
public class MemberSendsInvitation {
    private int invitationId;
    private int memberId;
    private Timestamp userSendsInvitationDate;

    @Id
    @Column(name = "INVITATION_ID", nullable = false, precision = 0)
    public int getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(int invitationId) {
        this.invitationId = invitationId;
    }

    @Id
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "USER_SENDS_INVITATION_DATE", nullable = true)
    public Timestamp getUserSendsInvitationDate() {
        return userSendsInvitationDate;
    }

    public void setUserSendsInvitationDate(Timestamp userSendsInvitationDate) {
        this.userSendsInvitationDate = userSendsInvitationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberSendsInvitation that = (MemberSendsInvitation) o;
        return invitationId == that.invitationId &&
                memberId == that.memberId &&
                Objects.equals(userSendsInvitationDate, that.userSendsInvitationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitationId, memberId, userSendsInvitationDate);
    }
}
