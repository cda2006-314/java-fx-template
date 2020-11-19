package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MESSAGE_HAS_MESSAGESTATUS", schema = "dbo")
@IdClass(MessageHasMessagestatusPK.class)
public class MessageHasMessagestatus {
    private int messageId;
    private int statusId;
    private Timestamp messageHasMessagestatusDate;
    private Message messageByMessageId;
    private Messagestatus messagestatusByStatusId;

    @Id
    @Column(name = "MESSAGE_ID", nullable = false, precision = 0)
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Id
    @Column(name = "STATUS_ID", nullable = false, precision = 0)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "MESSAGE_HAS_MESSAGESTATUS_DATE", nullable = true)
    public Timestamp getMessageHasMessagestatusDate() {
        return messageHasMessagestatusDate;
    }

    public void setMessageHasMessagestatusDate(Timestamp messageHasMessagestatusDate) {
        this.messageHasMessagestatusDate = messageHasMessagestatusDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageHasMessagestatus that = (MessageHasMessagestatus) o;
        return messageId == that.messageId &&
                statusId == that.statusId &&
                Objects.equals(messageHasMessagestatusDate, that.messageHasMessagestatusDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, statusId, messageHasMessagestatusDate);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_ID", referencedColumnName = "MESSAGE_ID", nullable = false)
    public Message getMessageByMessageId() {
        return messageByMessageId;
    }

    public void setMessageByMessageId(Message messageByMessageId) {
        this.messageByMessageId = messageByMessageId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID", nullable = false)
    public Messagestatus getMessagestatusByStatusId() {
        return messagestatusByStatusId;
    }

    public void setMessagestatusByStatusId(Messagestatus messagestatusByStatusId) {
        this.messagestatusByStatusId = messagestatusByStatusId;
    }
}
