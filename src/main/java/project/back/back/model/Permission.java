package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Permission {
    private int permissionId;
    private String permissionLabel;
    private Collection<Invitation> invitationsByPermissionId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERMISSION_ID", nullable = false, precision = 0)
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "PERMISSION_LABEL", nullable = false, length = 100)
    public String getPermissionLabel() {
        return permissionLabel;
    }

    public void setPermissionLabel(String permissionLabel) {
        this.permissionLabel = permissionLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return permissionId == that.permissionId &&
                Objects.equals(permissionLabel, that.permissionLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, permissionLabel);
    }

    @OneToMany(mappedBy = "permissionByPermissionId")
    public Collection<Invitation> getInvitationsByPermissionId() {
        return invitationsByPermissionId;
    }

    public void setInvitationsByPermissionId(Collection<Invitation> invitationsByPermissionId) {
        this.invitationsByPermissionId = invitationsByPermissionId;
    }
}
