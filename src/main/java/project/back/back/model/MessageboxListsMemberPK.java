package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MessageboxListsMemberPK implements Serializable {
    private int messageboxId;
    private int memberId;

    @Column(name = "MESSAGEBOX_ID", nullable = false, precision = 0)
    @Id
    public int getMessageboxId() {
        return messageboxId;
    }

    public void setMessageboxId(int messageboxId) {
        this.messageboxId = messageboxId;
    }

    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    @Id
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
        MessageboxListsMemberPK that = (MessageboxListsMemberPK) o;
        return messageboxId == that.messageboxId &&
                memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageboxId, memberId);
    }
}
