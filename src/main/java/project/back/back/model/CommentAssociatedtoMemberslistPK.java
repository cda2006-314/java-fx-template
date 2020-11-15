package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CommentAssociatedtoMemberslistPK implements Serializable {
    private int commentId;
    private int memberslistId;

    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    @Id
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Column(name = "MEMBERSLIST_ID", nullable = false, precision = 0)
    @Id
    public int getMemberslistId() {
        return memberslistId;
    }

    public void setMemberslistId(int memberslistId) {
        this.memberslistId = memberslistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentAssociatedtoMemberslistPK that = (CommentAssociatedtoMemberslistPK) o;
        return commentId == that.commentId &&
                memberslistId == that.memberslistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, memberslistId);
    }
}
