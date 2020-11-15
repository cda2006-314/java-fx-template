package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Fonts {
    private int fontsId;
    private String fontsLabel;
    private String fontsUrl;

    @Id
    @Column(name = "FONTS_ID", nullable = false, precision = 0)
    public int getFontsId() {
        return fontsId;
    }

    public void setFontsId(int fontsId) {
        this.fontsId = fontsId;
    }

    @Basic
    @Column(name = "FONTS_LABEL", nullable = false, length = 100)
    public String getFontsLabel() {
        return fontsLabel;
    }

    public void setFontsLabel(String fontsLabel) {
        this.fontsLabel = fontsLabel;
    }

    @Basic
    @Column(name = "FONTS_URL", nullable = false, length = 100)
    public String getFontsUrl() {
        return fontsUrl;
    }

    public void setFontsUrl(String fontsUrl) {
        this.fontsUrl = fontsUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fonts fonts = (Fonts) o;
        return fontsId == fonts.fontsId &&
                Objects.equals(fontsLabel, fonts.fontsLabel) &&
                Objects.equals(fontsUrl, fonts.fontsUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fontsId, fontsLabel, fontsUrl);
    }
}
