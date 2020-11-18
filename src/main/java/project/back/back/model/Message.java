package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Message {
    private int messageId;
    private String messageLabel;
    private Collection<MessageboxReceivesMessage> messageboxReceivesMessagesByMessageId;
    private Collection<MessageboxSendsMessage> messageboxSendsMessagesByMessageId;
    private Collection<MessageHasMessagestatus> messageHasMessagestatusesByMessageId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID", nullable = false, precision = 0)
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "MESSAGE_LABEL", nullable = false, length = 3000)
    public String getMessageLabel() {
        return messageLabel;
    }

    public void setMessageLabel(String messageLabel) {
        this.messageLabel = messageLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return messageId == message.messageId &&
                Objects.equals(messageLabel, message.messageLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageLabel);
    }

    @OneToMany(mappedBy = "messageByMessageId")
    public Collection<MessageboxReceivesMessage> getMessageboxReceivesMessagesByMessageId() {
        return messageboxReceivesMessagesByMessageId;
    }

    public void setMessageboxReceivesMessagesByMessageId(Collection<MessageboxReceivesMessage> messageboxReceivesMessagesByMessageId) {
        this.messageboxReceivesMessagesByMessageId = messageboxReceivesMessagesByMessageId;
    }

    @OneToMany(mappedBy = "messageByMessageId")
    public Collection<MessageboxSendsMessage> getMessageboxSendsMessagesByMessageId() {
        return messageboxSendsMessagesByMessageId;
    }

    public void setMessageboxSendsMessagesByMessageId(Collection<MessageboxSendsMessage> messageboxSendsMessagesByMessageId) {
        this.messageboxSendsMessagesByMessageId = messageboxSendsMessagesByMessageId;
    }

    @OneToMany(mappedBy = "messageByMessageId")
    public Collection<MessageHasMessagestatus> getMessageHasMessagestatusesByMessageId() {
        return messageHasMessagestatusesByMessageId;
    }

    public void setMessageHasMessagestatusesByMessageId(Collection<MessageHasMessagestatus> messageHasMessagestatusesByMessageId) {
        this.messageHasMessagestatusesByMessageId = messageHasMessagestatusesByMessageId;
    }
}
