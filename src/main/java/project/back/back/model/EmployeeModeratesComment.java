package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE_MODERATES_COMMENT", schema = "dbo")
@IdClass(EmployeeModeratesCommentPK.class)
public class EmployeeModeratesComment {
    private int commentId;
    private int employeeId;
    private Timestamp employeeModeratesCommentDate;
    private Boolean employeeModeratesCommentDelete;
    private Comment commentByCommentId;
    private Employee employeeByEmployeeId;

    @Id
    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "EMPLOYEE_MODERATES_COMMENT_DATE", nullable = true)
    public Timestamp getEmployeeModeratesCommentDate() {
        return employeeModeratesCommentDate;
    }

    public void setEmployeeModeratesCommentDate(Timestamp employeeModeratesCommentDate) {
        this.employeeModeratesCommentDate = employeeModeratesCommentDate;
    }

    @Basic
    @Column(name = "EMPLOYEE_MODERATES_COMMENT_DELETE", nullable = true)
    public Boolean getEmployeeModeratesCommentDelete() {
        return employeeModeratesCommentDelete;
    }

    public void setEmployeeModeratesCommentDelete(Boolean employeeModeratesCommentDelete) {
        this.employeeModeratesCommentDelete = employeeModeratesCommentDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeModeratesComment that = (EmployeeModeratesComment) o;
        return commentId == that.commentId &&
                employeeId == that.employeeId &&
                Objects.equals(employeeModeratesCommentDate, that.employeeModeratesCommentDate) &&
                Objects.equals(employeeModeratesCommentDelete, that.employeeModeratesCommentDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, employeeId, employeeModeratesCommentDate, employeeModeratesCommentDelete);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMENT_ID", referencedColumnName = "COMMENT_ID", nullable = false)
    public Comment getCommentByCommentId() {
        return commentByCommentId;
    }

    public void setCommentByCommentId(Comment commentByCommentId) {
        this.commentByCommentId = commentByCommentId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }
}
