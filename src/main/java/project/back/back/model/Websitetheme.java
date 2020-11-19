package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Websitetheme {
    private int websitethemeId;
    private String websitethemeLabel;
    private Collection<Preference> preferencesByWebsitethemeId;
    private Collection<WebsitethemeHasApi> websitethemeHasApisByWebsitethemeId;
    private Collection<WebsitethemeHasFonts> websitethemeHasFontsByWebsitethemeId;
    private Collection<WebsitethemeHasPicture> websitethemeHasPicturesByWebsitethemeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WEBSITETHEME_ID", nullable = false, precision = 0)
    public int getWebsitethemeId() {
        return websitethemeId;
    }

    public void setWebsitethemeId(int websitethemeId) {
        this.websitethemeId = websitethemeId;
    }

    @Basic
    @Column(name = "WEBSITETHEME_LABEL", nullable = false, length = 100)
    public String getWebsitethemeLabel() {
        return websitethemeLabel;
    }

    public void setWebsitethemeLabel(String websitethemeLabel) {
        this.websitethemeLabel = websitethemeLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Websitetheme that = (Websitetheme) o;
        return websitethemeId == that.websitethemeId &&
                Objects.equals(websitethemeLabel, that.websitethemeLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(websitethemeId, websitethemeLabel);
    }

    @OneToMany(mappedBy = "websitethemeByWebsitethemeId")
    public Collection<Preference> getPreferencesByWebsitethemeId() {
        return preferencesByWebsitethemeId;
    }

    public void setPreferencesByWebsitethemeId(Collection<Preference> preferencesByWebsitethemeId) {
        this.preferencesByWebsitethemeId = preferencesByWebsitethemeId;
    }

    @OneToMany(mappedBy = "websitethemeByWebsitethemeId")
    public Collection<WebsitethemeHasApi> getWebsitethemeHasApisByWebsitethemeId() {
        return websitethemeHasApisByWebsitethemeId;
    }

    public void setWebsitethemeHasApisByWebsitethemeId(Collection<WebsitethemeHasApi> websitethemeHasApisByWebsitethemeId) {
        this.websitethemeHasApisByWebsitethemeId = websitethemeHasApisByWebsitethemeId;
    }

    @OneToMany(mappedBy = "websitethemeByWebsitethemeId")
    public Collection<WebsitethemeHasFonts> getWebsitethemeHasFontsByWebsitethemeId() {
        return websitethemeHasFontsByWebsitethemeId;
    }

    public void setWebsitethemeHasFontsByWebsitethemeId(Collection<WebsitethemeHasFonts> websitethemeHasFontsByWebsitethemeId) {
        this.websitethemeHasFontsByWebsitethemeId = websitethemeHasFontsByWebsitethemeId;
    }

    @OneToMany(mappedBy = "websitethemeByWebsitethemeId")
    public Collection<WebsitethemeHasPicture> getWebsitethemeHasPicturesByWebsitethemeId() {
        return websitethemeHasPicturesByWebsitethemeId;
    }

    public void setWebsitethemeHasPicturesByWebsitethemeId(Collection<WebsitethemeHasPicture> websitethemeHasPicturesByWebsitethemeId) {
        this.websitethemeHasPicturesByWebsitethemeId = websitethemeHasPicturesByWebsitethemeId;
    }
}
