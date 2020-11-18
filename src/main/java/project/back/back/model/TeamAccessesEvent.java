package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEAM_ACCESSES_EVENT", schema = "dbo")
@IdClass(TeamAccessesEventPK.class)
public class TeamAccessesEvent {
    private int eventId;
    private int teamId;
    private Event eventByEventId;
    private Team teamByTeamId;

    @Id
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Id
    @Column(name = "TEAM_ID", nullable = false, precision = 0)
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
        TeamAccessesEvent that = (TeamAccessesEvent) o;
        return eventId == that.eventId &&
                teamId == that.teamId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, teamId);
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
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID", nullable = false)
    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }
}
