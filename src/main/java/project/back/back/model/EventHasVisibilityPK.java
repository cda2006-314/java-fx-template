package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EventHasVisibilityPK implements Serializable {
    private int visibilityId;
    private int eventId;

    @Column(name = "VISIBILITY_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getVisibilityId() {
        return visibilityId;
    }

    public void setVisibilityId(int visibilityId) {
        this.visibilityId = visibilityId;
    }

    @Column(name = "EVENT_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventHasVisibilityPK that = (EventHasVisibilityPK) o;
        return visibilityId == that.visibilityId &&
                eventId == that.eventId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visibilityId, eventId);
    }
}
