package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "WEBSITETHEME_HAS_FONTS", schema = "dbo")
@IdClass(WebsitethemeHasFontsPK.class)
public class WebsitethemeHasFonts {
    private int websitethemeId;
    private int fontsId;
    private Websitetheme websitethemeByWebsitethemeId;
    private Fonts fontsByFontsId;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WEBSITETHEME_ID", referencedColumnName = "WEBSITETHEME_ID", nullable = false)
    public Websitetheme getWebsitethemeByWebsitethemeId() {
        return websitethemeByWebsitethemeId;
    }

    public void setWebsitethemeByWebsitethemeId(Websitetheme websitethemeByWebsitethemeId) {
        this.websitethemeByWebsitethemeId = websitethemeByWebsitethemeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FONTS_ID", referencedColumnName = "FONTS_ID", nullable = false)
    public Fonts getFontsByFontsId() {
        return fontsByFontsId;
    }

    public void setFontsByFontsId(Fonts fontsByFontsId) {
        this.fontsByFontsId = fontsByFontsId;
    }
}
