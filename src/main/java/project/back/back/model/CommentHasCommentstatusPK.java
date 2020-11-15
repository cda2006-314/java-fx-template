package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CommentHasCommentstatusPK implements Serializable {
    private int commentstatusId;
    private int commentId;

    @Column(name = "COMMENTSTATUS_ID", nullable = false, precision = 0)
    @Id
    public int getCommentstatusId() {
        return commentstatusId;
    }

    public void setCommentstatusId(int commentstatusId) {
        this.commentstatusId = commentstatusId;
    }

    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
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
        CommentHasCommentstatusPK that = (CommentHasCommentstatusPK) o;
        return commentstatusId == that.commentstatusId &&
                commentId == that.commentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentstatusId, commentId);
    }
}
