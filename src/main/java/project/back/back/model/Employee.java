package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Employee {
    private int employeeId;
    private String employeeLogin;
    private String employeePassword;
    private Collection<EmployeeAdministratesWebcontent> employeeAdministratesWebcontentsByEmployeeId;
    private Collection<EmployeeModeratesComment> employeeModeratesCommentsByEmployeeId;
    private Collection<EmployeeModeratesEvent> employeeModeratesEventsByEmployeeId;
    private Collection<EmployeeModeratesMember> employeeModeratesMembersByEmployeeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "EMPLOYEE_LOGIN", nullable = false, length = 320)
    public String getEmployeeLogin() {
        return employeeLogin;
    }

    public void setEmployeeLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    @Basic
    @Column(name = "EMPLOYEE_PASSWORD", nullable = false, length = 2048)
    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                Objects.equals(employeeLogin, employee.employeeLogin) &&
                Objects.equals(employeePassword, employee.employeePassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeLogin, employeePassword);
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<EmployeeAdministratesWebcontent> getEmployeeAdministratesWebcontentsByEmployeeId() {
        return employeeAdministratesWebcontentsByEmployeeId;
    }

    public void setEmployeeAdministratesWebcontentsByEmployeeId(Collection<EmployeeAdministratesWebcontent> employeeAdministratesWebcontentsByEmployeeId) {
        this.employeeAdministratesWebcontentsByEmployeeId = employeeAdministratesWebcontentsByEmployeeId;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<EmployeeModeratesComment> getEmployeeModeratesCommentsByEmployeeId() {
        return employeeModeratesCommentsByEmployeeId;
    }

    public void setEmployeeModeratesCommentsByEmployeeId(Collection<EmployeeModeratesComment> employeeModeratesCommentsByEmployeeId) {
        this.employeeModeratesCommentsByEmployeeId = employeeModeratesCommentsByEmployeeId;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<EmployeeModeratesEvent> getEmployeeModeratesEventsByEmployeeId() {
        return employeeModeratesEventsByEmployeeId;
    }

    public void setEmployeeModeratesEventsByEmployeeId(Collection<EmployeeModeratesEvent> employeeModeratesEventsByEmployeeId) {
        this.employeeModeratesEventsByEmployeeId = employeeModeratesEventsByEmployeeId;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<EmployeeModeratesMember> getEmployeeModeratesMembersByEmployeeId() {
        return employeeModeratesMembersByEmployeeId;
    }

    public void setEmployeeModeratesMembersByEmployeeId(Collection<EmployeeModeratesMember> employeeModeratesMembersByEmployeeId) {
        this.employeeModeratesMembersByEmployeeId = employeeModeratesMembersByEmployeeId;
    }
}
