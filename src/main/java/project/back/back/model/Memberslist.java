package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Memberslist {
    private int memberslistId;
    private int teamId;
    private String memberslistLabel;
    private Timestamp teamHasUserslistDate;

    @Id
    @Column(name = "MEMBERSLIST_ID", nullable = false, precision = 0)
    public int getMemberslistId() {
        return memberslistId;
    }

    public void setMemberslistId(int memberslistId) {
        this.memberslistId = memberslistId;
    }

    @Basic
    @Column(name = "TEAM_ID", nullable = false, precision = 0)
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "MEMBERSLIST_LABEL", nullable = true, length = 50)
    public String getMemberslistLabel() {
        return memberslistLabel;
    }

    public void setMemberslistLabel(String memberslistLabel) {
        this.memberslistLabel = memberslistLabel;
    }

    @Basic
    @Column(name = "TEAM_HAS_USERSLIST_DATE", nullable = true)
    public Timestamp getTeamHasUserslistDate() {
        return teamHasUserslistDate;
    }

    public void setTeamHasUserslistDate(Timestamp teamHasUserslistDate) {
        this.teamHasUserslistDate = teamHasUserslistDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memberslist that = (Memberslist) o;
        return memberslistId == that.memberslistId &&
                teamId == that.teamId &&
                Objects.equals(memberslistLabel, that.memberslistLabel) &&
                Objects.equals(teamHasUserslistDate, that.teamHasUserslistDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberslistId, teamId, memberslistLabel, teamHasUserslistDate);
    }
}
