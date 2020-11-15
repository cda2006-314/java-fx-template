package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MemberFollowsanotherMemberPK implements Serializable {
    private int member1Id;
    private int member2Id;

    @Column(name = "MEMBER1_ID", nullable = false, precision = 0)
    @Id
    public int getMember1Id() {
        return member1Id;
    }

    public void setMember1Id(int member1Id) {
        this.member1Id = member1Id;
    }

    @Column(name = "MEMBER2_ID", nullable = false, precision = 0)
    @Id
    public int getMember2Id() {
        return member2Id;
    }

    public void setMember2Id(int member2Id) {
        this.member2Id = member2Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberFollowsanotherMemberPK that = (MemberFollowsanotherMemberPK) o;
        return member1Id == that.member1Id &&
                member2Id == that.member2Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(member1Id, member2Id);
    }
}
