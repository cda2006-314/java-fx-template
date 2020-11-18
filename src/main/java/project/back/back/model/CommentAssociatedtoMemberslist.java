package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "COMMENT_ASSOCIATEDTO_MEMBERSLIST", schema = "dbo")
@IdClass(CommentAssociatedtoMemberslistPK.class)
public class CommentAssociatedtoMemberslist {
    private int commentId;
    private int memberslistId;
    private Timestamp commentAssociatedtoMemberslistDate;
    private Comment commentByCommentId;
    private Memberslist memberslistByMemberslistId;

    @Id
    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Id
    @Column(name = "MEMBERSLIST_ID", nullable = false, precision = 0)
    public int getMemberslistId() {
        return memberslistId;
    }

    public void setMemberslistId(int memberslistId) {
        this.memberslistId = memberslistId;
    }

    @Basic
    @Column(name = "COMMENT_ASSOCIATEDTO_MEMBERSLIST_DATE", nullable = true)
    public Timestamp getCommentAssociatedtoMemberslistDate() {
        return commentAssociatedtoMemberslistDate;
    }

    public void setCommentAssociatedtoMemberslistDate(Timestamp commentAssociatedtoMemberslistDate) {
        this.commentAssociatedtoMemberslistDate = commentAssociatedtoMemberslistDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentAssociatedtoMemberslist that = (CommentAssociatedtoMemberslist) o;
        return commentId == that.commentId &&
                memberslistId == that.memberslistId &&
                Objects.equals(commentAssociatedtoMemberslistDate, that.commentAssociatedtoMemberslistDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, memberslistId, commentAssociatedtoMemberslistDate);
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
    @JoinColumn(name = "MEMBERSLIST_ID", referencedColumnName = "MEMBERSLIST_ID", nullable = false)
    public Memberslist getMemberslistByMemberslistId() {
        return memberslistByMemberslistId;
    }

    public void setMemberslistByMemberslistId(Memberslist memberslistByMemberslistId) {
        this.memberslistByMemberslistId = memberslistByMemberslistId;
    }
}
