package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Visibility {
    private int visibilityId;
    private String visibilityLabel;
    private Collection<EventHasVisibility> eventHasVisibilitiesByVisibilityId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public String toString() {
        return visibilityLabel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visibilityId, visibilityLabel);
    }

    @OneToMany(mappedBy = "visibilityByVisibilityId")
    public Collection<EventHasVisibility> getEventHasVisibilitiesByVisibilityId() {
        return eventHasVisibilitiesByVisibilityId;
    }

    public void setEventHasVisibilitiesByVisibilityId(Collection<EventHasVisibility> eventHasVisibilitiesByVisibilityId) {
        this.eventHasVisibilitiesByVisibilityId = eventHasVisibilitiesByVisibilityId;
    }
}
