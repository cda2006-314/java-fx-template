package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Eventstatus {
    private int eventstatusId;
    private String eventstatusLabel;
    private Collection<EventHasEventstatus> eventHasEventstatusesByEventstatusId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENTSTATUS_ID", nullable = false, precision = 0)
    public int getEventstatusId() {
        return eventstatusId;
    }

    public void setEventstatusId(int eventstatusId) {
        this.eventstatusId = eventstatusId;
    }

    @Basic
    @Column(name = "EVENTSTATUS_LABEL", nullable = false, length = 100)
    public String getEventstatusLabel() {
        return eventstatusLabel;
    }

    public void setEventstatusLabel(String eventstatusLabel) {
        this.eventstatusLabel = eventstatusLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eventstatus that = (Eventstatus) o;
        return eventstatusId == that.eventstatusId &&
                Objects.equals(eventstatusLabel, that.eventstatusLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventstatusId, eventstatusLabel);
    }

    @OneToMany(mappedBy = "eventstatusByEventstatusId")
    public Collection<EventHasEventstatus> getEventHasEventstatusesByEventstatusId() {
        return eventHasEventstatusesByEventstatusId;
    }

    public void setEventHasEventstatusesByEventstatusId(Collection<EventHasEventstatus> eventHasEventstatusesByEventstatusId) {
        this.eventHasEventstatusesByEventstatusId = eventHasEventstatusesByEventstatusId;
    }
}
