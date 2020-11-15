package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MessageboxReceivesMessagePK implements Serializable {
    private int messageboxId;
    private int messageId;

    @Column(name = "MESSAGEBOX_ID", nullable = false, precision = 0)
    @Id
    public int getMessageboxId() {
        return messageboxId;
    }

    public void setMessageboxId(int messageboxId) {
        this.messageboxId = messageboxId;
    }

    @Column(name = "MESSAGE_ID", nullable = false, precision = 0)
    @Id
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageboxReceivesMessagePK that = (MessageboxReceivesMessagePK) o;
        return messageboxId == that.messageboxId &&
                messageId == that.messageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageboxId, messageId);
    }
}
