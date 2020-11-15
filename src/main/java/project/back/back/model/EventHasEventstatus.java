package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EVENT_HAS_EVENTSTATUS", schema = "dbo" )
@IdClass(EventHasEventstatusPK.class)
public class EventHasEventstatus {
    private int eventId;
    private int eventstatusId;
    private Timestamp eventHasEventstatusDate;

    @Id
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Id
    @Column(name = "EVENTSTATUS_ID", nullable = false, precision = 0)
    public int getEventstatusId() {
        return eventstatusId;
    }

    public void setEventstatusId(int eventstatusId) {
        this.eventstatusId = eventstatusId;
    }

    @Basic
    @Column(name = "EVENT_HAS_EVENTSTATUS_DATE", nullable = true)
    public Timestamp getEventHasEventstatusDate() {
        return eventHasEventstatusDate;
    }

    public void setEventHasEventstatusDate(Timestamp eventHasEventstatusDate) {
        this.eventHasEventstatusDate = eventHasEventstatusDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventHasEventstatus that = (EventHasEventstatus) o;
        return eventId == that.eventId &&
                eventstatusId == that.eventstatusId &&
                Objects.equals(eventHasEventstatusDate, that.eventHasEventstatusDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventstatusId, eventHasEventstatusDate);
    }
}
