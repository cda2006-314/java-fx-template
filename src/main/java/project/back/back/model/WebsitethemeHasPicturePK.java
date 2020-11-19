package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WebsitethemeHasPicturePK implements Serializable {
    private int websitethemeId;
    private int pictureId;

    @Column(name = "WEBSITETHEME_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
    public int getWebsitethemeId() {
        return websitethemeId;
    }

    public void setWebsitethemeId(int websitethemeId) {
        this.websitethemeId = websitethemeId;
    }

    @Column(name = "PICTURE_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    @Id
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
        WebsitethemeHasPicturePK that = (WebsitethemeHasPicturePK) o;
        return websitethemeId == that.websitethemeId &&
                pictureId == that.pictureId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(websitethemeId, pictureId);
    }
}
