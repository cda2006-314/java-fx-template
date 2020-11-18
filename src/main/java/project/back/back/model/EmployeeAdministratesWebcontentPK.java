package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmployeeAdministratesWebcontentPK implements Serializable {
    private int employeeId;
    private int webcontentId;

    @Column(name = "EMPLOYEE_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "WEBCONTENT_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getWebcontentId() {
        return webcontentId;
    }

    public void setWebcontentId(int webcontentId) {
        this.webcontentId = webcontentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAdministratesWebcontentPK that = (EmployeeAdministratesWebcontentPK) o;
        return employeeId == that.employeeId &&
                webcontentId == that.webcontentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, webcontentId);
    }
}
