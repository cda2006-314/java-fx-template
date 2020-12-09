package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_HAS_PREFERENCES", schema = "dbo")

@IdClass(MemberHasPreferencesPK.class)
public class MemberHasPreferences {
    private int memberId;
    private int preferenceId;
    private Member memberByMemberId;
    private Preference preferenceByPreferenceId;

    @Id
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Id
    @Column(name = "PREFERENCE_ID", nullable = false, precision = 0)
    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberHasPreferences that = (MemberHasPreferences) o;
        return memberId == that.memberId &&
                preferenceId == that.preferenceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, preferenceId);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PREFERENCE_ID", referencedColumnName = "PREFERENCE_ID", nullable = false)
    public Preference getPreferenceByPreferenceId() {
        return preferenceByPreferenceId;
    }

    public void setPreferenceByPreferenceId(Preference preferenceByPreferenceId) {
        this.preferenceByPreferenceId = preferenceByPreferenceId;
    }
}
