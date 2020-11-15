package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MESSAGEBOX_LISTS_MEMBER", schema = "dbo" )
@IdClass(MessageboxListsMemberPK.class)
public class MessageboxListsMember {
    private int messageboxId;
    private int memberId;

    @Id
    @Column(name = "MESSAGEBOX_ID", nullable = false, precision = 0)
    public int getMessageboxId() {
        return messageboxId;
    }

    public void setMessageboxId(int messageboxId) {
        this.messageboxId = messageboxId;
    }

    @Id
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
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
        MessageboxListsMember that = (MessageboxListsMember) o;
        return messageboxId == that.messageboxId &&
                memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageboxId, memberId);
    }
}
