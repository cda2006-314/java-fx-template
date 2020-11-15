package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LibraryHasMediastockPK implements Serializable {
    private int libraryId;
    private String mediastockLinkid;

    @Column(name = "LIBRARY_ID", nullable = false, precision = 0)
    @Id
    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    @Column(name = "MEDIASTOCK_LINKID", nullable = false, length = 1)
    @Id
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
        LibraryHasMediastockPK that = (LibraryHasMediastockPK) o;
        return libraryId == that.libraryId &&
                Objects.equals(mediastockLinkid, that.mediastockLinkid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, mediastockLinkid);
    }
}
