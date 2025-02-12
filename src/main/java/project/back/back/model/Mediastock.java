package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Mediastock {
    private String mediastockLinkid;
    private Collection<LibraryHasMediastock> libraryHasMediastocksByMediastockLinkid;

    @Id
    @Column(name = "MEDIASTOCK_LINKID", nullable = false, length = 250)
    public String getMediastockLinkid() {
        return mediastockLinkid;
    }

    public void setMediastockLinkid(String mediastockLinkid) {
        this.mediastockLinkid = mediastockLinkid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mediastock that = (Mediastock) o;
        return Objects.equals(mediastockLinkid, that.mediastockLinkid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediastockLinkid);
    }

    @OneToMany(mappedBy = "mediastockByMediastockLinkid")
    public Collection<LibraryHasMediastock> getLibraryHasMediastocksByMediastockLinkid() {
        return libraryHasMediastocksByMediastockLinkid;
    }

    public void setLibraryHasMediastocksByMediastockLinkid(Collection<LibraryHasMediastock> libraryHasMediastocksByMediastockLinkid) {
        this.libraryHasMediastocksByMediastockLinkid = libraryHasMediastocksByMediastockLinkid;
    }
}
