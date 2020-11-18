package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE_MODERATES_MEMBER", schema = "dbo")
@IdClass(EmployeeModeratesMemberPK.class)
public class EmployeeModeratesMember {
    private int employeeId;
    private int memberId;
    private Timestamp employeeModeratesMemberDate;
    private Employee employeeByEmployeeId;
    private Member memberByMemberId;

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "EMPLOYEE_MODERATES_MEMBER_DATE", nullable = true)
    public Timestamp getEmployeeModeratesMemberDate() {
        return employeeModeratesMemberDate;
    }

    public void setEmployeeModeratesMemberDate(Timestamp employeeModeratesMemberDate) {
        this.employeeModeratesMemberDate = employeeModeratesMemberDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeModeratesMember that = (EmployeeModeratesMember) o;
        return employeeId == that.employeeId &&
                memberId == that.memberId &&
                Objects.equals(employeeModeratesMemberDate, that.employeeModeratesMemberDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, memberId, employeeModeratesMemberDate);
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
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }
}
