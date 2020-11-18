package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COMMENT_CANHAVE_MEDIA", schema = "dbo")
@IdClass(CommentCanhaveMediaPK.class)
public class CommentCanhaveMedia {
    private int mediaId;
    private int commentId;
    private Media mediaByMediaId;
    private Comment commentByCommentId;

    @Id
    @Column(name = "MEDIA_ID", nullable = false, precision = 0)
    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    @Id
    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
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
        CommentCanhaveMedia that = (CommentCanhaveMedia) o;
        return mediaId == that.mediaId &&
                commentId == that.commentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaId, commentId);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDIA_ID", referencedColumnName = "MEDIA_ID", nullable = false)
    public Media getMediaByMediaId() {
        return mediaByMediaId;
    }

    public void setMediaByMediaId(Media mediaByMediaId) {
        this.mediaByMediaId = mediaByMediaId;
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
