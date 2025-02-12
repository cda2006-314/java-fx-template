package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "COMMENT_HAS_COMMENTSTATUS", schema = "dbo")
@IdClass(CommentHasCommentstatusPK.class)
public class CommentHasCommentstatus {
    private int commentstatusId;
    private int commentId;
    private Timestamp commentHasCommentstatusDate;
    private Commentstatus commentstatusByCommentstatusId;
    private Comment commentByCommentId;

    @Id
    @Column(name = "COMMENTSTATUS_ID", nullable = false, precision = 0)
    public int getCommentstatusId() {
        return commentstatusId;
    }

    public void setCommentstatusId(int commentstatusId) {
        this.commentstatusId = commentstatusId;
    }

    @Id
    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "COMMENT_HAS_COMMENTSTATUS_DATE", nullable = true)
    public Timestamp getCommentHasCommentstatusDate() {
        return commentHasCommentstatusDate;
    }

    public void setCommentHasCommentstatusDate(Timestamp commentHasCommentstatusDate) {
        this.commentHasCommentstatusDate = commentHasCommentstatusDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentHasCommentstatus that = (CommentHasCommentstatus) o;
        return commentstatusId == that.commentstatusId &&
                commentId == that.commentId &&
                Objects.equals(commentHasCommentstatusDate, that.commentHasCommentstatusDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentstatusId, commentId, commentHasCommentstatusDate);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMENTSTATUS_ID", referencedColumnName = "COMMENTSTATUS_ID", nullable = false)
    public Commentstatus getCommentstatusByCommentstatusId() {
        return commentstatusByCommentstatusId;
    }

    public void setCommentstatusByCommentstatusId(Commentstatus commentstatusByCommentstatusId) {
        this.commentstatusByCommentstatusId = commentstatusByCommentstatusId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMENT_ID", referencedColumnName = "COMMENT_ID", nullable = false)
    public Comment getCommentByCommentId() {
        return commentByCommentId;
    }

    public void setCommentByCommentId(Comment commentByCommentId) {
        this.commentByCommentId = commentByCommentId;
    }
}
