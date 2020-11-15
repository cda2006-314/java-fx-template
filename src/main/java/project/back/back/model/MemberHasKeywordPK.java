package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MemberHasKeywordPK implements Serializable {
    private String keywordLabel;
    private int memberId;

    @Column(name = "KEYWORD_LABEL", nullable = false, length = 100)
    @Id
    public String getKeywordLabel() {
        return keywordLabel;
    }

    public void setKeywordLabel(String keywordLabel) {
        this.keywordLabel = keywordLabel;
    }

    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    @Id
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberHasKeywordPK that = (MemberHasKeywordPK) o;
        return memberId == that.memberId &&
                Objects.equals(keywordLabel, that.keywordLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keywordLabel, memberId);
    }
}
