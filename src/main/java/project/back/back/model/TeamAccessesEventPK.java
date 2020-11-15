package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TeamAccessesEventPK implements Serializable {
    private int eventId;
    private int teamId;

    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    @Id
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Column(name = "TEAM_ID", nullable = false, precision = 0)
    @Id
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamAccessesEventPK that = (TeamAccessesEventPK) o;
        return eventId == that.eventId &&
                teamId == that.teamId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, teamId);
    }
}
