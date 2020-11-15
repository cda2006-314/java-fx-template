package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Datechart {
    private int datechartId;
    private int eventId;
    private Timestamp datechartCreation;
    private Timestamp datechartStart;
    private Timestamp datechartEnd;
    private Timestamp datechartLabelstart;
    private Timestamp datechartLabelend;
    private Timestamp eventHasDatechartDate;

    @Id
    @Column(name = "DATECHART_ID", nullable = false, precision = 0)
    public int getDatechartId() {
        return datechartId;
    }

    public void setDatechartId(int datechartId) {
        this.datechartId = datechartId;
    }

    @Basic
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "DATECHART_CREATION", nullable = false)
    public Timestamp getDatechartCreation() {
        return datechartCreation;
    }

    public void setDatechartCreation(Timestamp datechartCreation) {
        this.datechartCreation = datechartCreation;
    }

    @Basic
    @Column(name = "DATECHART_START", nullable = false)
    public Timestamp getDatechartStart() {
        return datechartStart;
    }

    public void setDatechartStart(Timestamp datechartStart) {
        this.datechartStart = datechartStart;
    }

    @Basic
    @Column(name = "DATECHART_END", nullable = true)
    public Timestamp getDatechartEnd() {
        return datechartEnd;
    }

    public void setDatechartEnd(Timestamp datechartEnd) {
        this.datechartEnd = datechartEnd;
    }

    @Basic
    @Column(name = "DATECHART_LABELSTART", nullable = true)
    public Timestamp getDatechartLabelstart() {
        return datechartLabelstart;
    }

    public void setDatechartLabelstart(Timestamp datechartLabelstart) {
        this.datechartLabelstart = datechartLabelstart;
    }

    @Basic
    @Column(name = "DATECHART_LABELEND", nullable = true)
    public Timestamp getDatechartLabelend() {
        return datechartLabelend;
    }

    public void setDatechartLabelend(Timestamp datechartLabelend) {
        this.datechartLabelend = datechartLabelend;
    }

    @Basic
    @Column(name = "EVENT_HAS_DATECHART_DATE", nullable = false)
    public Timestamp getEventHasDatechartDate() {
        return eventHasDatechartDate;
    }

    public void setEventHasDatechartDate(Timestamp eventHasDatechartDate) {
        this.eventHasDatechartDate = eventHasDatechartDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datechart datechart = (Datechart) o;
        return datechartId == datechart.datechartId &&
                eventId == datechart.eventId &&
                Objects.equals(datechartCreation, datechart.datechartCreation) &&
                Objects.equals(datechartStart, datechart.datechartStart) &&
                Objects.equals(datechartEnd, datechart.datechartEnd) &&
                Objects.equals(datechartLabelstart, datechart.datechartLabelstart) &&
                Objects.equals(datechartLabelend, datechart.datechartLabelend) &&
                Objects.equals(eventHasDatechartDate, datechart.eventHasDatechartDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datechartId, eventId, datechartCreation, datechartStart, datechartEnd, datechartLabelstart, datechartLabelend, eventHasDatechartDate);
    }
}
