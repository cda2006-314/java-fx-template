package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Invitation {
    private int invitationId;
    private int memberslistId;
    private int permissionId;
    private boolean invitationIsaccepted;
    private Memberslist memberslistByMemberslistId;
    private Permission permissionByPermissionId;
    private Collection<InvitationTargetsMember> invitationTargetsMembersByInvitationId;
    private Collection<MemberRevokesInvitation> memberRevokesInvitationsByInvitationId;
    private Collection<MemberSendsInvitation> memberSendsInvitationsByInvitationId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVITATION_ID", nullable = false, precision = 0)
    public int getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(int invitationId) {
        this.invitationId = invitationId;
    }

    @Basic
    @Column(name = "MEMBERSLIST_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    public int getMemberslistId() {
        return memberslistId;
    }

    public void setMemberslistId(int memberslistId) {
        this.memberslistId = memberslistId;
    }

    @Basic
    @Column(name = "PERMISSION_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "INVITATION_ISACCEPTED", nullable = false)
    public boolean isInvitationIsaccepted() {
        return invitationIsaccepted;
    }

    public void setInvitationIsaccepted(boolean invitationIsaccepted) {
        this.invitationIsaccepted = invitationIsaccepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invitation that = (Invitation) o;
        return invitationId == that.invitationId &&
                memberslistId == that.memberslistId &&
                permissionId == that.permissionId &&
                invitationIsaccepted == that.invitationIsaccepted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitationId, memberslistId, permissionId, invitationIsaccepted);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBERSLIST_ID", referencedColumnName = "MEMBERSLIST_ID", nullable = false)
    public Memberslist getMemberslistByMemberslistId() {
        return memberslistByMemberslistId;
    }

    public void setMemberslistByMemberslistId(Memberslist memberslistByMemberslistId) {
        this.memberslistByMemberslistId = memberslistByMemberslistId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "PERMISSION_ID", nullable = false)
    public Permission getPermissionByPermissionId() {
        return permissionByPermissionId;
    }

    public void setPermissionByPermissionId(Permission permissionByPermissionId) {
        this.permissionByPermissionId = permissionByPermissionId;
    }

    @OneToMany(mappedBy = "invitationByInvitationId")
    public Collection<InvitationTargetsMember> getInvitationTargetsMembersByInvitationId() {
        return invitationTargetsMembersByInvitationId;
    }

    public void setInvitationTargetsMembersByInvitationId(Collection<InvitationTargetsMember> invitationTargetsMembersByInvitationId) {
        this.invitationTargetsMembersByInvitationId = invitationTargetsMembersByInvitationId;
    }

    @OneToMany(mappedBy = "invitationByInvitationId")
    public Collection<MemberRevokesInvitation> getMemberRevokesInvitationsByInvitationId() {
        return memberRevokesInvitationsByInvitationId;
    }

    public void setMemberRevokesInvitationsByInvitationId(Collection<MemberRevokesInvitation> memberRevokesInvitationsByInvitationId) {
        this.memberRevokesInvitationsByInvitationId = memberRevokesInvitationsByInvitationId;
    }

    @OneToMany(mappedBy = "invitationByInvitationId")
    public Collection<MemberSendsInvitation> getMemberSendsInvitationsByInvitationId() {
        return memberSendsInvitationsByInvitationId;
    }

    public void setMemberSendsInvitationsByInvitationId(Collection<MemberSendsInvitation> memberSendsInvitationsByInvitationId) {
        this.memberSendsInvitationsByInvitationId = memberSendsInvitationsByInvitationId;
    }
}
