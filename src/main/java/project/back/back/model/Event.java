package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Event {
    private int eventId;
    private int memberId;
    private String eventLabel;
    private int eventLikes;
    private String eventPostit;
    private boolean eventIssponsored;

    @Id
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "EVENT_LABEL", nullable = false, length = 100)
    public String getEventLabel() {
        return eventLabel;
    }

    public void setEventLabel(String eventLabel) {
        this.eventLabel = eventLabel;
    }

    @Basic
    @Column(name = "EVENT_LIKES", nullable = false)
    public int getEventLikes() {
        return eventLikes;
    }

    public void setEventLikes(int eventLikes) {
        this.eventLikes = eventLikes;
    }

    @Basic
    @Column(name = "EVENT_POSTIT", nullable = true, length = 100)
    public String getEventPostit() {
        return eventPostit;
    }

    public void setEventPostit(String eventPostit) {
        this.eventPostit = eventPostit;
    }

    @Basic
    @Column(name = "EVENT_ISSPONSORED", nullable = false)
    public boolean isEventIssponsored() {
        return eventIssponsored;
    }

    public void setEventIssponsored(boolean eventIssponsored) {
        this.eventIssponsored = eventIssponsored;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId == event.eventId &&
                memberId == event.memberId &&
                eventLikes == event.eventLikes &&
                eventIssponsored == event.eventIssponsored &&
                Objects.equals(eventLabel, event.eventLabel) &&
                Objects.equals(eventPostit, event.eventPostit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, memberId, eventLabel, eventLikes, eventPostit, eventIssponsored);
    }
}
