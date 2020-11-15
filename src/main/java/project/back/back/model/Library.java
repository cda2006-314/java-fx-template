package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Library {
    private int libraryId;
    private int memberId;
    private String libraryMediaid;

    @Id
    @Column(name = "LIBRARY_ID", nullable = false, precision = 0)
    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    @Basic
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "LIBRARY_MEDIAID", nullable = false, length = 32)
    public String getLibraryMediaid() {
        return libraryMediaid;
    }

    public void setLibraryMediaid(String libraryMediaid) {
        this.libraryMediaid = libraryMediaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return libraryId == library.libraryId &&
                memberId == library.memberId &&
                Objects.equals(libraryMediaid, library.libraryMediaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, memberId, libraryMediaid);
    }
}
