package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEAM_HAS_TEAMSTATUS", schema = "dbo")
@IdClass(TeamHasTeamstatusPK.class)
public class TeamHasTeamstatus {
    private int groupstatusId;
    private int teamId;
    private Groupstatus groupstatusByGroupstatusId;
    private Team teamByTeamId;

    @Id
    @Column(name = "GROUPSTATUS_ID", nullable = false, precision = 0)
    public int getGroupstatusId() {
        return groupstatusId;
    }

    public void setGroupstatusId(int groupstatusId) {
        this.groupstatusId = groupstatusId;
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
        TeamHasTeamstatus that = (TeamHasTeamstatus) o;
        return groupstatusId == that.groupstatusId &&
                teamId == that.teamId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupstatusId, teamId);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUPSTATUS_ID", referencedColumnName = "GROUPSTATUS_ID", nullable = false)
    public Groupstatus getGroupstatusByGroupstatusId() {
        return groupstatusByGroupstatusId;
    }

    public void setGroupstatusByGroupstatusId(Groupstatus groupstatusByGroupstatusId) {
        this.groupstatusByGroupstatusId = groupstatusByGroupstatusId;
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
