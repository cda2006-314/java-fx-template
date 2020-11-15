package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Commentstatus {
    private int commentstatusId;
    private String commentstatusLabel;

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
}
