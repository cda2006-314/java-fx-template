package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EventHasKeywordPK implements Serializable {
    private int eventId;
    private String keywordLabel;

    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    @Id
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Column(name = "KEYWORD_LABEL", nullable = false, length = 100)
    @Id
    public String getKeywordLabel() {
        return keywordLabel;
    }

    public void setKeywordLabel(String keywordLabel) {
        this.keywordLabel = keywordLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventHasKeywordPK that = (EventHasKeywordPK) o;
        return eventId == that.eventId &&
                Objects.equals(keywordLabel, that.keywordLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, keywordLabel);
    }
}
