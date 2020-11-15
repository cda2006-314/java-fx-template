package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EventHasEventstatusPK implements Serializable {
    private int eventId;
    private int eventstatusId;

    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    @Id
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Column(name = "EVENTSTATUS_ID", nullable = false, precision = 0)
    @Id
    public int getEventstatusId() {
        return eventstatusId;
    }

    public void setEventstatusId(int eventstatusId) {
        this.eventstatusId = eventstatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventHasEventstatusPK that = (EventHasEventstatusPK) o;
        return eventId == that.eventId &&
                eventstatusId == that.eventstatusId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventstatusId);
    }
}
