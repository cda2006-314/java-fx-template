package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Groupstatus {
    private int groupstatusId;
    private String groupstatusLabel;
    private Collection<TeamHasTeamstatus> teamHasTeamstatusesByGroupstatusId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUPSTATUS_ID", nullable = false, precision = 0)
    public int getGroupstatusId() {
        return groupstatusId;
    }

    public void setGroupstatusId(int groupstatusId) {
        this.groupstatusId = groupstatusId;
    }

    @Basic
    @Column(name = "GROUPSTATUS_LABEL", nullable = false, length = 100)
    public String getGroupstatusLabel() {
        return groupstatusLabel;
    }

    public void setGroupstatusLabel(String groupstatusLabel) {
        this.groupstatusLabel = groupstatusLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groupstatus that = (Groupstatus) o;
        return groupstatusId == that.groupstatusId &&
                Objects.equals(groupstatusLabel, that.groupstatusLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupstatusId, groupstatusLabel);
    }

    @OneToMany(mappedBy = "groupstatusByGroupstatusId")
    public Collection<TeamHasTeamstatus> getTeamHasTeamstatusesByGroupstatusId() {
        return teamHasTeamstatusesByGroupstatusId;
    }

    public void setTeamHasTeamstatusesByGroupstatusId(Collection<TeamHasTeamstatus> teamHasTeamstatusesByGroupstatusId) {
        this.teamHasTeamstatusesByGroupstatusId = teamHasTeamstatusesByGroupstatusId;
    }
}
