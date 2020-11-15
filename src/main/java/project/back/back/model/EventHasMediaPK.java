package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EventHasMediaPK implements Serializable {
    private int eventId;
    private int mediaId;

    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    @Id
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Column(name = "MEDIA_ID", nullable = false, precision = 0)
    @Id
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
        EventHasMediaPK that = (EventHasMediaPK) o;
        return eventId == that.eventId &&
                mediaId == that.mediaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, mediaId);
    }
}
