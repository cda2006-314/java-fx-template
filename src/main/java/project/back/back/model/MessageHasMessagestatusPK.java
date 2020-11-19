package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MessageHasMessagestatusPK implements Serializable {
    private int messageId;
    private int statusId;

    @Column(name = "MESSAGE_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Column(name = "STATUS_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageHasMessagestatusPK that = (MessageHasMessagestatusPK) o;
        return messageId == that.messageId &&
                statusId == that.statusId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, statusId);
    }
}
