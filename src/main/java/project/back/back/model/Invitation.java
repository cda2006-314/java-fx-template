package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Invitation {
    private int invitationId;
    private int memberslistId;
    private int permissionId;
    private boolean invitationIsaccepted;

    @Id
    @Column(name = "INVITATION_ID", nullable = false, precision = 0)
    public int getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(int invitationId) {
        this.invitationId = invitationId;
    }

    @Basic
    @Column(name = "MEMBERSLIST_ID", nullable = false, precision = 0)
    public int getMemberslistId() {
        return memberslistId;
    }

    public void setMemberslistId(int memberslistId) {
        this.memberslistId = memberslistId;
    }

    @Basic
    @Column(name = "PERMISSION_ID", nullable = false, precision = 0)
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
}
