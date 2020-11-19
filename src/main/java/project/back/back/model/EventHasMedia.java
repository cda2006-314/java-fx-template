package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EVENT_HAS_MEDIA", schema = "dbo")
@IdClass(EventHasMediaPK.class)
public class EventHasMedia {
    private int eventId;
    private int mediaId;
    private Event eventByEventId;
    private Media mediaByMediaId;

    @Id
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Id
    @Column(name = "MEDIA_ID", nullable = false, precision = 0)
    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventHasMedia that = (EventHasMedia) o;
        return eventId == that.eventId &&
                mediaId == that.mediaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, mediaId);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", nullable = false)
    public Event getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(Event eventByEventId) {
        this.eventByEventId = eventByEventId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDIA_ID", referencedColumnName = "MEDIA_ID", nullable = false)
    public Media getMediaByMediaId() {
        return mediaByMediaId;
    }

    public void setMediaByMediaId(Media mediaByMediaId) {
        this.mediaByMediaId = mediaByMediaId;
    }
}
