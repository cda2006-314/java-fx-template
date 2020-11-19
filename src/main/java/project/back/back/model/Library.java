package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Library {
    private int libraryId;
    private int memberId;
    private String libraryMediaid;
    private Member memberByMemberId;
    private Collection<LibraryHasMediastock> libraryHasMediastocksByLibraryId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIBRARY_ID", nullable = false, precision = 0)
    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    @Basic
    @Column(name = "MEMBER_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "LIBRARY_MEDIAID", nullable = false, length = 100)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }

    @OneToMany(mappedBy = "libraryByLibraryId")
    public Collection<LibraryHasMediastock> getLibraryHasMediastocksByLibraryId() {
        return libraryHasMediastocksByLibraryId;
    }

    public void setLibraryHasMediastocksByLibraryId(Collection<LibraryHasMediastock> libraryHasMediastocksByLibraryId) {
        this.libraryHasMediastocksByLibraryId = libraryHasMediastocksByLibraryId;
    }
}
