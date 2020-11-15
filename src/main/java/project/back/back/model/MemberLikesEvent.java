package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_LIKES_EVENT", schema = "dbo" )
@IdClass(MemberLikesEventPK.class)
public class MemberLikesEvent {
    private int eventId;
    private int memberId;

    @Id
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
        MemberLikesEvent that = (MemberLikesEvent) o;
        return eventId == that.eventId &&
                memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, memberId);
    }
}
