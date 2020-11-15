package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LIBRARY_HAS_MEDIASTOCK", schema = "dbo" )
@IdClass(LibraryHasMediastockPK.class)
public class LibraryHasMediastock {
    private int libraryId;
    private String mediastockLinkid;

    @Id
    @Column(name = "LIBRARY_ID", nullable = false, precision = 0)
    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    @Id
    @Column(name = "MEDIASTOCK_LINKID", nullable = false, length = 1)
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
        LibraryHasMediastock that = (LibraryHasMediastock) o;
        return libraryId == that.libraryId &&
                Objects.equals(mediastockLinkid, that.mediastockLinkid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, mediastockLinkid);
    }
}
