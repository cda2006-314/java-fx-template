package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_HAS_KEYWORD", schema = "dbo" )
@IdClass(MemberHasKeywordPK.class)
public class MemberHasKeyword {
    private String keywordLabel;
    private int memberId;

    @Id
    @Column(name = "KEYWORD_LABEL", nullable = false, length = 100)
    public String getKeywordLabel() {
        return keywordLabel;
    }

    public void setKeywordLabel(String keywordLabel) {
        this.keywordLabel = keywordLabel;
    }

    @Id
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
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
        MemberHasKeyword that = (MemberHasKeyword) o;
        return memberId == that.memberId &&
                Objects.equals(keywordLabel, that.keywordLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keywordLabel, memberId);
    }
}
