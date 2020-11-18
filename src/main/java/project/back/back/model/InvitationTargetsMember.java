package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "INVITATION_TARGETS_MEMBER", schema = "dbo")
@IdClass(InvitationTargetsMemberPK.class)
public class InvitationTargetsMember {
    private int invitationId;
    private int memberId;
    private Timestamp invitationTargetsMemberDate;
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
    @Column(name = "INVITATION_TARGETS_MEMBER_DATE", nullable = true)
    public Timestamp getInvitationTargetsMemberDate() {
        return invitationTargetsMemberDate;
    }

    public void setInvitationTargetsMemberDate(Timestamp invitationTargetsMemberDate) {
        this.invitationTargetsMemberDate = invitationTargetsMemberDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvitationTargetsMember that = (InvitationTargetsMember) o;
        return invitationId == that.invitationId &&
                memberId == that.memberId &&
                Objects.equals(invitationTargetsMemberDate, that.invitationTargetsMemberDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitationId, memberId, invitationTargetsMemberDate);
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
