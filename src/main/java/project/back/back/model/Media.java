package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Media {
    private int mediaId;
    private String mediaLabel;
    private String mediaExtension;
    private Collection<CommentCanhaveMedia> commentCanhaveMediaByMediaId;
    private Collection<EventHasMedia> eventHasMediaByMediaId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEDIA_ID", nullable = false, precision = 0)
    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    @Basic
    @Column(name = "MEDIA_LABEL", nullable = false, length = 100)
    public String getMediaLabel() {
        return mediaLabel;
    }

    public void setMediaLabel(String mediaLabel) {
        this.mediaLabel = mediaLabel;
    }

    @Basic
    @Column(name = "MEDIA_EXTENSION", nullable = false, length = 10)
    public String getMediaExtension() {
        return mediaExtension;
    }

    public void setMediaExtension(String mediaExtension) {
        this.mediaExtension = mediaExtension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return mediaId == media.mediaId &&
                Objects.equals(mediaLabel, media.mediaLabel) &&
                Objects.equals(mediaExtension, media.mediaExtension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaId, mediaLabel, mediaExtension);
    }

    @OneToMany(mappedBy = "mediaByMediaId")
    public Collection<CommentCanhaveMedia> getCommentCanhaveMediaByMediaId() {
        return commentCanhaveMediaByMediaId;
    }

    public void setCommentCanhaveMediaByMediaId(Collection<CommentCanhaveMedia> commentCanhaveMediaByMediaId) {
        this.commentCanhaveMediaByMediaId = commentCanhaveMediaByMediaId;
    }

    @OneToMany(mappedBy = "mediaByMediaId")
    public Collection<EventHasMedia> getEventHasMediaByMediaId() {
        return eventHasMediaByMediaId;
    }

    public void setEventHasMediaByMediaId(Collection<EventHasMedia> eventHasMediaByMediaId) {
        this.eventHasMediaByMediaId = eventHasMediaByMediaId;
    }
}
