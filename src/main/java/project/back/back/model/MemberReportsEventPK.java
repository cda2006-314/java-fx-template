package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MemberReportsEventPK implements Serializable {
    private int eventId;
    private int memberId;

    @Column(name = "EVENT_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Column(name = "MEMBER_ID", insertable = false, updatable = false, nullable = false, precision = 0)
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
        MemberReportsEventPK that = (MemberReportsEventPK) o;
        return eventId == that.eventId &&
                memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, memberId);
    }
}
