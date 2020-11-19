package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Commentstatus {
    private int commentstatusId;
    private String commentstatusLabel;
    private Collection<CommentHasCommentstatus> commentHasCommentstatusesByCommentstatusId;

    @Id
    @Column(name = "COMMENTSTATUS_ID", nullable = false, precision = 0)
    public int getCommentstatusId() {
        return commentstatusId;
    }

    public void setCommentstatusId(int commentstatusId) {
        this.commentstatusId = commentstatusId;
    }

    @Basic
    @Column(name = "COMMENTSTATUS_LABEL", nullable = false, length = 100)
    public String getCommentstatusLabel() {
        return commentstatusLabel;
    }

    public void setCommentstatusLabel(String commentstatusLabel) {
        this.commentstatusLabel = commentstatusLabel;
    }

    @Override
    public String toString() {
        return commentstatusLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commentstatus that = (Commentstatus) o;
        return commentstatusId == that.commentstatusId &&
                Objects.equals(commentstatusLabel, that.commentstatusLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentstatusId, commentstatusLabel);
    }

    @OneToMany(mappedBy = "commentstatusByCommentstatusId")
    public Collection<CommentHasCommentstatus> getCommentHasCommentstatusesByCommentstatusId() {
        return commentHasCommentstatusesByCommentstatusId;
    }

    public void setCommentHasCommentstatusesByCommentstatusId(Collection<CommentHasCommentstatus> commentHasCommentstatusesByCommentstatusId) {
        this.commentHasCommentstatusesByCommentstatusId = commentHasCommentstatusesByCommentstatusId;
    }
}
