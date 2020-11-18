package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MESSAGEBOX_RECEIVES_MESSAGE", schema = "dbo")
@IdClass(MessageboxReceivesMessagePK.class)
public class MessageboxReceivesMessage {
    private int messageboxId;
    private int messageId;
    private Timestamp messageboxReceivesMessageDate;
    private Messagebox messageboxByMessageboxId;
    private Message messageByMessageId;

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
    @Column(name = "MESSAGEBOX_RECEIVES_MESSAGE_DATE", nullable = true)
    public Timestamp getMessageboxReceivesMessageDate() {
        return messageboxReceivesMessageDate;
    }

    public void setMessageboxReceivesMessageDate(Timestamp messageboxReceivesMessageDate) {
        this.messageboxReceivesMessageDate = messageboxReceivesMessageDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageboxReceivesMessage that = (MessageboxReceivesMessage) o;
        return messageboxId == that.messageboxId &&
                messageId == that.messageId &&
                Objects.equals(messageboxReceivesMessageDate, that.messageboxReceivesMessageDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageboxId, messageId, messageboxReceivesMessageDate);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGEBOX_ID", referencedColumnName = "MESSAGEBOX_ID", nullable = false)
    public Messagebox getMessageboxByMessageboxId() {
        return messageboxByMessageboxId;
    }

    public void setMessageboxByMessageboxId(Messagebox messageboxByMessageboxId) {
        this.messageboxByMessageboxId = messageboxByMessageboxId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_ID", referencedColumnName = "MESSAGE_ID", nullable = false)
    public Message getMessageByMessageId() {
        return messageByMessageId;
    }

    public void setMessageByMessageId(Message messageByMessageId) {
        this.messageByMessageId = messageByMessageId;
    }
}
