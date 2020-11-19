package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Messagestatus {
    private int statusId;
    private String statusLabel;
    private Collection<MessageHasMessagestatus> messageHasMessagestatusesByStatusId;

    @Id
    @Column(name = "STATUS_ID", nullable = false, precision = 0)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "STATUS_LABEL", nullable = false, length = 100)
    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    @Override
    public String toString() {
        return statusLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messagestatus that = (Messagestatus) o;
        return statusId == that.statusId &&
                Objects.equals(statusLabel, that.statusLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, statusLabel);
    }

    @OneToMany(mappedBy = "messagestatusByStatusId")
    public Collection<MessageHasMessagestatus> getMessageHasMessagestatusesByStatusId() {
        return messageHasMessagestatusesByStatusId;
    }

    public void setMessageHasMessagestatusesByStatusId(Collection<MessageHasMessagestatus> messageHasMessagestatusesByStatusId) {
        this.messageHasMessagestatusesByStatusId = messageHasMessagestatusesByStatusId;
    }
}
