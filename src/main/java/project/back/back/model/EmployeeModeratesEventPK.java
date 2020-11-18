package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmployeeModeratesEventPK implements Serializable {
    private int employeeId;
    private int eventId;

    @Column(name = "EMPLOYEE_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
        EmployeeModeratesEventPK that = (EmployeeModeratesEventPK) o;
        return employeeId == that.employeeId &&
                eventId == that.eventId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, eventId);
    }
}
