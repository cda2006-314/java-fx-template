package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


public class MemberHasPreferencesPK implements Serializable {

    private int memberId;
   private int preferenceId;

    public MemberHasPreferencesPK(){}



    @Column(name = "MEMBER_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Column(name = "PREFERENCE_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
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
        MemberHasPreferencesPK that = (MemberHasPreferencesPK) o;
        return memberId == that.memberId &&
                preferenceId == that.preferenceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, preferenceId);
    }
}
