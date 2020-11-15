package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CommentCanhaveMediaPK implements Serializable {
    private int mediaId;
    private int commentId;

    @Column(name = "MEDIA_ID", nullable = false, precision = 0)
    @Id
    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
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
        CommentCanhaveMediaPK that = (CommentCanhaveMediaPK) o;
        return mediaId == that.mediaId &&
                commentId == that.commentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaId, commentId);
    }
}
