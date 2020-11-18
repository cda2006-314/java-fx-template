package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_REVOKES_INVITATION", schema = "dbo")
@IdClass(MemberRevokesInvitationPK.class)
public class MemberRevokesInvitation {
    private int invitationId;
    private int memberId;
    private Timestamp memberRevokesInvitationDate;
    private Invitation invitationByInvitationId;
    private Member memberByMemberId;

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
    @Column(name = "MEMBER_REVOKES_INVITATION_DATE", nullable = true)
    public Timestamp getMemberRevokesInvitationDate() {
        return memberRevokesInvitationDate;
    }

    public void setMemberRevokesInvitationDate(Timestamp memberRevokesInvitationDate) {
        this.memberRevokesInvitationDate = memberRevokesInvitationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberRevokesInvitation that = (MemberRevokesInvitation) o;
        return invitationId == that.invitationId &&
                memberId == that.memberId &&
                Objects.equals(memberRevokesInvitationDate, that.memberRevokesInvitationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitationId, memberId, memberRevokesInvitationDate);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVITATION_ID", referencedColumnName = "INVITATION_ID", nullable = false)
    public Invitation getInvitationByInvitationId() {
        return invitationByInvitationId;
    }

    public void setInvitationByInvitationId(Invitation invitationByInvitationId) {
        this.invitationByInvitationId = invitationByInvitationId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }
}
