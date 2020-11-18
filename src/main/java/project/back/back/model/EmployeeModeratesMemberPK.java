package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmployeeModeratesMemberPK implements Serializable {
    private int employeeId;
    private int memberId;

    @Column(name = "EMPLOYEE_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "MEMBER_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
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
        EmployeeModeratesMemberPK that = (EmployeeModeratesMemberPK) o;
        return employeeId == that.employeeId &&
                memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, memberId);
    }
}
