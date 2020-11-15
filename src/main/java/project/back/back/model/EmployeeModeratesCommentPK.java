package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmployeeModeratesCommentPK implements Serializable {
    private int commentId;
    private int employeeId;

    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    @Id
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeModeratesCommentPK that = (EmployeeModeratesCommentPK) o;
        return commentId == that.commentId &&
                employeeId == that.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, employeeId);
    }
}
