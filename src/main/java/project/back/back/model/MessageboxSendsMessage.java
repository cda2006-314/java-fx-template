package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MESSAGEBOX_SENDS_MESSAGE", schema = "dbo" )
@IdClass(MessageboxSendsMessagePK.class)
public class MessageboxSendsMessage {
    private int messageboxId;
    private int messageId;
    private Timestamp messageboxSendsMessageDate;

    @Id
    @Column(name = "MESSAGEBOX_ID", nullable = false, precision = 0)
    public int getMessageboxId() {
        return messageboxId;
    }

    public void setMessageboxId(int messageboxId) {
        this.messageboxId = messageboxId;
    }

    @Id
    @Column(name = "MESSAGE_ID", nullable = false, precision = 0)
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "MESSAGEBOX_SENDS_MESSAGE_DATE", nullable = true)
    public Timestamp getMessageboxSendsMessageDate() {
        return messageboxSendsMessageDate;
    }

    public void setMessageboxSendsMessageDate(Timestamp messageboxSendsMessageDate) {
        this.messageboxSendsMessageDate = messageboxSendsMessageDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageboxSendsMessage that = (MessageboxSendsMessage) o;
        return messageboxId == that.messageboxId &&
                messageId == that.messageId &&
                Objects.equals(messageboxSendsMessageDate, that.messageboxSendsMessageDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageboxId, messageId, messageboxSendsMessageDate);
    }
}
