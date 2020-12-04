package project.back.back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Preference {
    private int preferenceId;
    private int websitethemeId;
    private String preferenceLabel;
    private String preferenceDescription;
    private Collection<MemberHasPreferences> memberHasPreferencesByPreferenceId;
    private Websitetheme websitethemeByWebsitethemeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREFERENCE_ID", nullable = false, precision = 0)
    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    @Basic
    @Column(name = "WEBSITETHEME_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    public int getWebsitethemeId() {
        return websitethemeId;
    }

    public void setWebsitethemeId(int websitethemeId) {
        this.websitethemeId = websitethemeId;
    }

    @Basic
    @Column(name = "PREFERENCE_LABEL", nullable = false, length = 100)
    public String getPreferenceLabel() {
        return preferenceLabel;
    }

    public void setPreferenceLabel(String preferenceLabel) {
        this.preferenceLabel = preferenceLabel;
    }

    @Basic
    @Column(name = "PREFERENCE_DESCRIPTION", nullable = false, length = 100)
    public String getPreferenceDescription() {
        return preferenceDescription;
    }

    public void setPreferenceDescription(String preferenceDescription) {
        this.preferenceDescription = preferenceDescription;
    }

    @Override
    public String toString() {
        return preferenceLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preference that = (Preference) o;
        return preferenceId == that.preferenceId &&
                websitethemeId == that.websitethemeId &&
                Objects.equals(preferenceLabel, that.preferenceLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferenceId, websitethemeId, preferenceLabel);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "preferenceByPreferenceId")
    @JsonIgnore
    public Collection<MemberHasPreferences> getMemberHasPreferencesByPreferenceId() {
        return memberHasPreferencesByPreferenceId;
    }

    public void setMemberHasPreferencesByPreferenceId(Collection<MemberHasPreferences> memberHasPreferencesByPreferenceId) {
        this.memberHasPreferencesByPreferenceId = memberHasPreferencesByPreferenceId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "WEBSITETHEME_ID", referencedColumnName = "WEBSITETHEME_ID", nullable = false)
    public Websitetheme getWebsitethemeByWebsitethemeId() {
        return websitethemeByWebsitethemeId;
    }

    public void setWebsitethemeByWebsitethemeId(Websitetheme websitethemeByWebsitethemeId) {
        this.websitethemeByWebsitethemeId = websitethemeByWebsitethemeId;
    }
}
