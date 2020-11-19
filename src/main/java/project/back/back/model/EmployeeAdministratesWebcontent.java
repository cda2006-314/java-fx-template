package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE_ADMINISTRATES_WEBCONTENT", schema = "dbo")
@IdClass(EmployeeAdministratesWebcontentPK.class)
public class EmployeeAdministratesWebcontent {
    private int employeeId;
    private int webcontentId;
    private Employee employeeByEmployeeId;
    private Webcontent webcontentByWebcontentId;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WEBCONTENT_ID", referencedColumnName = "WEBCONTENT_ID", nullable = false)
    public Webcontent getWebcontentByWebcontentId() {
        return webcontentByWebcontentId;
    }

    public void setWebcontentByWebcontentId(Webcontent webcontentByWebcontentId) {
        this.webcontentByWebcontentId = webcontentByWebcontentId;
    }
}
