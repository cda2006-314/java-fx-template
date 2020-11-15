package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Visibility {
    private int visibilityId;
    private String visibilityLabel;

    @Id
    @Column(name = "VISIBILITY_ID", nullable = false, precision = 0)
    public int getVisibilityId() {
        return visibilityId;
    }

    public void setVisibilityId(int visibilityId) {
        this.visibilityId = visibilityId;
    }

    @Basic
    @Column(name = "VISIBILITY_LABEL", nullable = false, length = 100)
    public String getVisibilityLabel() {
        return visibilityLabel;
    }

    public void setVisibilityLabel(String visibilityLabel) {
        this.visibilityLabel = visibilityLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visibility that = (Visibility) o;
        return visibilityId == that.visibilityId &&
                Objects.equals(visibilityLabel, that.visibilityLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visibilityId, visibilityLabel);
    }
}
