package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EVENT_HAS_KEYWORD", schema = "dbo")
@IdClass(EventHasKeywordPK.class)
public class EventHasKeyword {
    private int eventId;
    private String keywordLabel;
    private Event eventByEventId;
    private Keyword keywordByKeywordLabel;

    @Id
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Id
    @Column(name = "KEYWORD_LABEL", nullable = false, length = 100)
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
        EventHasKeyword that = (EventHasKeyword) o;
        return eventId == that.eventId &&
                Objects.equals(keywordLabel, that.keywordLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, keywordLabel);
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
    @JoinColumn(name = "KEYWORD_LABEL", referencedColumnName = "KEYWORD_LABEL", nullable = false)
    public Keyword getKeywordByKeywordLabel() {
        return keywordByKeywordLabel;
    }

    public void setKeywordByKeywordLabel(Keyword keywordByKeywordLabel) {
        this.keywordByKeywordLabel = keywordByKeywordLabel;
    }
}
