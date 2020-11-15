package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Websitetheme {
    private int websitethemeId;
    private String websitethemeLabel;
    private Collection<Api> api;
    private Collection<Fonts> fonts;
    private Collection<Picture> picture;

    public Websitetheme(){}

    public Websitetheme(Collection<Api> api, Collection<Fonts> fonts, Collection<Picture> picture){this.api = api; this.fonts = fonts; this.picture = picture;}
    @Id
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
}
