package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Keyword {
    private String keywordLabel;
    private Collection<EventHasKeyword> eventHasKeywordsByKeywordLabel;
    private Collection<MemberHasKeyword> memberHasKeywordsByKeywordLabel;

    @Id
    @Column(name = "KEYWORD_LABEL", nullable = false, length = 100)
    public String getKeywordLabel() {
        return keywordLabel;
    }

    public void setKeywordLabel(String keywordLabel) {
        this.keywordLabel = keywordLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword = (Keyword) o;
        return Objects.equals(keywordLabel, keyword.keywordLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keywordLabel);
    }

    @OneToMany(mappedBy = "keywordByKeywordLabel")
    public Collection<EventHasKeyword> getEventHasKeywordsByKeywordLabel() {
        return eventHasKeywordsByKeywordLabel;
    }

    public void setEventHasKeywordsByKeywordLabel(Collection<EventHasKeyword> eventHasKeywordsByKeywordLabel) {
        this.eventHasKeywordsByKeywordLabel = eventHasKeywordsByKeywordLabel;
    }

    @OneToMany(mappedBy = "keywordByKeywordLabel")
    public Collection<MemberHasKeyword> getMemberHasKeywordsByKeywordLabel() {
        return memberHasKeywordsByKeywordLabel;
    }

    public void setMemberHasKeywordsByKeywordLabel(Collection<MemberHasKeyword> memberHasKeywordsByKeywordLabel) {
        this.memberHasKeywordsByKeywordLabel = memberHasKeywordsByKeywordLabel;
    }
}
