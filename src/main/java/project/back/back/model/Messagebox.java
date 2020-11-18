package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Messagebox {
    private int messageboxId;
    private int memberId;
    private Member memberByMemberId;
    private Collection<MessageboxListsMember> messageboxListsMembersByMessageboxId;
    private Collection<MessageboxReceivesMessage> messageboxReceivesMessagesByMessageboxId;
    private Collection<MessageboxSendsMessage> messageboxSendsMessagesByMessageboxId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGEBOX_ID", nullable = false, precision = 0)
    public int getMessageboxId() {
        return messageboxId;
    }

    public void setMessageboxId(int messageboxId) {
        this.messageboxId = messageboxId;
    }

    @Basic
    @Column(name = "MEMBER_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messagebox that = (Messagebox) o;
        return messageboxId == that.messageboxId &&
                memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageboxId, memberId);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }

    @OneToMany(mappedBy = "messageboxByMessageboxId")
    public Collection<MessageboxListsMember> getMessageboxListsMembersByMessageboxId() {
        return messageboxListsMembersByMessageboxId;
    }

    public void setMessageboxListsMembersByMessageboxId(Collection<MessageboxListsMember> messageboxListsMembersByMessageboxId) {
        this.messageboxListsMembersByMessageboxId = messageboxListsMembersByMessageboxId;
    }

    @OneToMany(mappedBy = "messageboxByMessageboxId")
    public Collection<MessageboxReceivesMessage> getMessageboxReceivesMessagesByMessageboxId() {
        return messageboxReceivesMessagesByMessageboxId;
    }

    public void setMessageboxReceivesMessagesByMessageboxId(Collection<MessageboxReceivesMessage> messageboxReceivesMessagesByMessageboxId) {
        this.messageboxReceivesMessagesByMessageboxId = messageboxReceivesMessagesByMessageboxId;
    }

    @OneToMany(mappedBy = "messageboxByMessageboxId")
    public Collection<MessageboxSendsMessage> getMessageboxSendsMessagesByMessageboxId() {
        return messageboxSendsMessagesByMessageboxId;
    }

    public void setMessageboxSendsMessagesByMessageboxId(Collection<MessageboxSendsMessage> messageboxSendsMessagesByMessageboxId) {
        this.messageboxSendsMessagesByMessageboxId = messageboxSendsMessagesByMessageboxId;
    }
}
