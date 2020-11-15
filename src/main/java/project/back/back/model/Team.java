package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Team {
    private int teamId;
    private int memberId;
    private String teamLabel;
    private String teamDescription;
    private String teamPicurl;

    @Id
    @Column(name = "TEAM_ID", nullable = false, precision = 0)
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "TEAM_LABEL", nullable = false, length = 100)
    public String getTeamLabel() {
        return teamLabel;
    }

    public void setTeamLabel(String teamLabel) {
        this.teamLabel = teamLabel;
    }

    @Basic
    @Column(name = "TEAM_DESCRIPTION", nullable = true, length = 500)
    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    @Basic
    @Column(name = "TEAM_PICURL", nullable = false, length = 256)
    public String getTeamPicurl() {
        return teamPicurl;
    }

    public void setTeamPicurl(String teamPicurl) {
        this.teamPicurl = teamPicurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamId == team.teamId &&
                memberId == team.memberId &&
                Objects.equals(teamLabel, team.teamLabel) &&
                Objects.equals(teamDescription, team.teamDescription) &&
                Objects.equals(teamPicurl, team.teamPicurl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, memberId, teamLabel, teamDescription, teamPicurl);
    }
}
