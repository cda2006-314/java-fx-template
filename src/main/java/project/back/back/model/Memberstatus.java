package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Memberstatus {
    private int memberstatusId;
    private String memberstatusLabel;
    private Collection<MemberHasMemberstatus> memberHasMemberstatusesByMemberstatusId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBERSTATUS_ID", nullable = false, precision = 0)
    public int getMemberstatusId() {
        return memberstatusId;
    }

    public void setMemberstatusId(int memberstatusId) {
        this.memberstatusId = memberstatusId;
    }

    @Basic
    @Column(name = "MEMBERSTATUS_LABEL", nullable = false, length = 100)
    public String getMemberstatusLabel() {
        return memberstatusLabel;
    }

    public void setMemberstatusLabel(String memberstatusLabel) {
        this.memberstatusLabel = memberstatusLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memberstatus that = (Memberstatus) o;
        return memberstatusId == that.memberstatusId &&
                Objects.equals(memberstatusLabel, that.memberstatusLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberstatusId, memberstatusLabel);
    }

    @OneToMany(mappedBy = "memberstatusByMemberstatusId")
    public Collection<MemberHasMemberstatus> getMemberHasMemberstatusesByMemberstatusId() {
        return memberHasMemberstatusesByMemberstatusId;
    }

    public void setMemberHasMemberstatusesByMemberstatusId(Collection<MemberHasMemberstatus> memberHasMemberstatusesByMemberstatusId) {
        this.memberHasMemberstatusesByMemberstatusId = memberHasMemberstatusesByMemberstatusId;
    }
}
