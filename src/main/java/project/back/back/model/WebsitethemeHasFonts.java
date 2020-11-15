package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "WEBSITETHEME_HAS_FONTS", schema = "dbo" )
@IdClass(WebsitethemeHasFontsPK.class)
public class WebsitethemeHasFonts {
    private int websitethemeId;
    private int fontsId;

    @Id
    @Column(name = "WEBSITETHEME_ID", nullable = false, precision = 0)
    public int getWebsitethemeId() {
        return websitethemeId;
    }

    public void setWebsitethemeId(int websitethemeId) {
        this.websitethemeId = websitethemeId;
    }

    @Id
    @Column(name = "FONTS_ID", nullable = false, precision = 0)
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
        WebsitethemeHasFonts that = (WebsitethemeHasFonts) o;
        return websitethemeId == that.websitethemeId &&
                fontsId == that.fontsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(websitethemeId, fontsId);
    }
}
