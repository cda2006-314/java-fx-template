package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WebsitethemeHasFontsPK implements Serializable {
    private int websitethemeId;
    private int fontsId;

    @Column(name = "WEBSITETHEME_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getWebsitethemeId() {
        return websitethemeId;
    }

    public void setWebsitethemeId(int websitethemeId) {
        this.websitethemeId = websitethemeId;
    }

    @Column(name = "FONTS_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getFontsId() {
        return fontsId;
    }

    public void setFontsId(int fontsId) {
        this.fontsId = fontsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebsitethemeHasFontsPK that = (WebsitethemeHasFontsPK) o;
        return websitethemeId == that.websitethemeId &&
                fontsId == that.fontsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(websitethemeId, fontsId);
    }
}
