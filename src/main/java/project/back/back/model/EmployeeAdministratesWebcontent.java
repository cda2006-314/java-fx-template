package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE_ADMINISTRATES_WEBCONTENT", schema = "dbo")
@IdClass(EmployeeAdministratesWebcontentPK.class)
public class EmployeeAdministratesWebcontent {
    private int employeeId;
    private int webcontentId;

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @Column(name = "WEBCONTENT_ID", nullable = false, precision = 0)
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
        EmployeeAdministratesWebcontent that = (EmployeeAdministratesWebcontent) o;
        return employeeId == that.employeeId &&
                webcontentId == that.webcontentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, webcontentId);
    }
}
