package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MemberReportsCommentPK implements Serializable {
    private int commentId;
    private int memberId;

    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    @Id
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
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
        MemberReportsCommentPK that = (MemberReportsCommentPK) o;
        return commentId == that.commentId &&
                memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, memberId);
    }
}
