package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MemberLikesCommentPK implements Serializable {
    private int memberId;
    private int commentId;

    @Column(name = "MEMBER_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Column(name = "COMMENT_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberLikesCommentPK that = (MemberLikesCommentPK) o;
        return memberId == that.memberId &&
                commentId == that.commentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, commentId);
    }
}
