package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "WEBSITETHEME_HAS_PICTURE", schema = "dbo")
@IdClass(WebsitethemeHasPicturePK.class)
public class WebsitethemeHasPicture {
    private int websitethemeId;
    private int pictureId;
    private Websitetheme websitethemeByWebsitethemeId;
    private Picture pictureByPictureId;

    @Id
    @Column(name = "WEBSITETHEME_ID", nullable = false, precision = 0)
    public int getWebsitethemeId() {
        return websitethemeId;
    }

    public void setWebsitethemeId(int websitethemeId) {
        this.websitethemeId = websitethemeId;
    }

    @Id
    @Column(name = "PICTURE_ID", nullable = false, precision = 0)
    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebsitethemeHasPicture that = (WebsitethemeHasPicture) o;
        return websitethemeId == that.websitethemeId &&
                pictureId == that.pictureId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(websitethemeId, pictureId);
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
    @JoinColumn(name = "PICTURE_ID", referencedColumnName = "PICTURE_ID", nullable = false)
    public Picture getPictureByPictureId() {
        return pictureByPictureId;
    }

    public void setPictureByPictureId(Picture pictureByPictureId) {
        this.pictureByPictureId = pictureByPictureId;
    }
}
