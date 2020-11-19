package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE_MODERATES_EVENT", schema = "dbo")
@IdClass(EmployeeModeratesEventPK.class)
public class EmployeeModeratesEvent {
    private int employeeId;
    private int eventId;
    private Timestamp employeeModeratesEventDate;
    private Boolean employeeModeratesEventDelete;
    private Employee employeeByEmployeeId;
    private Event eventByEventId;

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
    @Column(name = "EMPLOYEE_MODERATES_EVENT_DATE", nullable = true)
    public Timestamp getEmployeeModeratesEventDate() {
        return employeeModeratesEventDate;
    }

    public void setEmployeeModeratesEventDate(Timestamp employeeModeratesEventDate) {
        this.employeeModeratesEventDate = employeeModeratesEventDate;
    }

    @Basic
    @Column(name = "EMPLOYEE_MODERATES_EVENT_DELETE", nullable = true)
    public Boolean getEmployeeModeratesEventDelete() {
        return employeeModeratesEventDelete;
    }

    public void setEmployeeModeratesEventDelete(Boolean employeeModeratesEventDelete) {
        this.employeeModeratesEventDelete = employeeModeratesEventDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeModeratesEvent that = (EmployeeModeratesEvent) o;
        return employeeId == that.employeeId &&
                eventId == that.eventId &&
                Objects.equals(employeeModeratesEventDate, that.employeeModeratesEventDate) &&
                Objects.equals(employeeModeratesEventDelete, that.employeeModeratesEventDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, eventId, employeeModeratesEventDate, employeeModeratesEventDelete);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", nullable = false)
    public Event getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(Event eventByEventId) {
        this.eventByEventId = eventByEventId;
    }
}
