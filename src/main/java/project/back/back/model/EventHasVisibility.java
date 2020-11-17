package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EVENT_HAS_VISIBILITY", schema = "dbo" )
@IdClass(EventHasVisibilityPK.class)
public class EventHasVisibility {
    private int visibilityId;
    private int eventId;
    private Timestamp eventHasVisibilityDate;

    @Id
    @Column(name = "VISIBILITY_ID", nullable = false, precision = 0)
    public int getVisibilityId() {
        return visibilityId;
    }

    public void setVisibilityId(int visibilityId) {
        this.visibilityId = visibilityId;
    }

    @Id
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "EVENT_HAS_VISIBILITY_DATE", nullable = true)
    public Timestamp getEventHasVisibilityDate() {
        return eventHasVisibilityDate;
    }

    public void setEventHasVisibilityDate(Timestamp eventHasVisibilityDate) {
        this.eventHasVisibilityDate = eventHasVisibilityDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventHasVisibility that = (EventHasVisibility) o;
        return visibilityId == that.visibilityId &&
                eventId == that.eventId &&
                Objects.equals(eventHasVisibilityDate, that.eventHasVisibilityDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visibilityId, eventId, eventHasVisibilityDate);
    }
}