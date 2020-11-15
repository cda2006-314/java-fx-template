package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TeamHasTeamstatusPK implements Serializable {
    private int groupstatusId;
    private int teamId;

    @Column(name = "GROUPSTATUS_ID", nullable = false, precision = 0)
    @Id
    public int getGroupstatusId() {
        return groupstatusId;
    }

    public void setGroupstatusId(int groupstatusId) {
        this.groupstatusId = groupstatusId;
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
        TeamHasTeamstatusPK that = (TeamHasTeamstatusPK) o;
        return groupstatusId == that.groupstatusId &&
                teamId == that.teamId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupstatusId, teamId);
    }
}
