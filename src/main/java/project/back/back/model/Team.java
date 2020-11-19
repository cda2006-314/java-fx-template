package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Team {

    private int teamId;
    private int memberId;
    private String teamLabel;
    private String teamDescription;
    private String teamPicurl;
    private Collection<Memberslist> memberslistsByTeamId;
    private Member memberByMemberId;
    private Collection<TeamAccessesEvent> teamAccessesEventsByTeamId;
    private Collection<TeamHasTeamstatus> teamHasTeamstatusesByTeamId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID", nullable = false, precision = 0)
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Column(name = "MEMBER_ID", insertable = false, updatable = false, nullable = false, precision = 0)
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
    @Column(name = "TEAM_PICURL", nullable = false, length = 100)
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

    @OneToMany(mappedBy = "teamByTeamId")
    public Collection<Memberslist> getMemberslistsByTeamId() {
        return memberslistsByTeamId;
    }

    public void setMemberslistsByTeamId(Collection<Memberslist> memberslistsByTeamId) {
        this.memberslistsByTeamId = memberslistsByTeamId;
    }

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false, foreignKey=@ForeignKey(name="FK_TEAM_MEMBER_CREATES_TEAM_MEMBER"))
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public Collection<TeamAccessesEvent> getTeamAccessesEventsByTeamId() {
        return teamAccessesEventsByTeamId;
    }

    public void setTeamAccessesEventsByTeamId(Collection<TeamAccessesEvent> teamAccessesEventsByTeamId) {
        this.teamAccessesEventsByTeamId = teamAccessesEventsByTeamId;
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public Collection<TeamHasTeamstatus> getTeamHasTeamstatusesByTeamId() {
        return teamHasTeamstatusesByTeamId;
    }

    public void setTeamHasTeamstatusesByTeamId(Collection<TeamHasTeamstatus> teamHasTeamstatusesByTeamId) {
        this.teamHasTeamstatusesByTeamId = teamHasTeamstatusesByTeamId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamLabel='" + teamLabel + '\'' +

                "}\n";
    }
}
