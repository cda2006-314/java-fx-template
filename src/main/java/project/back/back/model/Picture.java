package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Picture {
    private int pictureId;
    private String pictureLabel;
    private String pictureUrl;

    @Id
    @Column(name = "PICTURE_ID", nullable = false, precision = 0)
    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    @Basic
    @Column(name = "PICTURE_LABEL", nullable = false, length = 100)
    public String getPictureLabel() {
        return pictureLabel;
    }

    public void setPictureLabel(String pictureLabel) {
        this.pictureLabel = pictureLabel;
    }

    @Basic
    @Column(name = "PICTURE_URL", nullable = false, length = 100)
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return pictureId == picture.pictureId &&
                Objects.equals(pictureLabel, picture.pictureLabel) &&
                Objects.equals(pictureUrl, picture.pictureUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pictureId, pictureLabel, pictureUrl);
    }
}
