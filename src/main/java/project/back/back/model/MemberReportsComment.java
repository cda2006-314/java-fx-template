package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_REPORTS_COMMENT", schema = "dbo")
@IdClass(MemberReportsCommentPK.class)
public class MemberReportsComment {
    private int commentId;
    private int memberId;
    private Timestamp memberReportsCommentDate;
    private String memberReportsCommentPostit;
    private Comment commentByCommentId;
    private Member memberByMemberId;

    @Id
    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Id
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "MEMBER_REPORTS_COMMENT_DATE", nullable = true)
    public Timestamp getMemberReportsCommentDate() {
        return memberReportsCommentDate;
    }

    public void setMemberReportsCommentDate(Timestamp memberReportsCommentDate) {
        this.memberReportsCommentDate = memberReportsCommentDate;
    }

    @Basic
    @Column(name = "MEMBER_REPORTS_COMMENT_POSTIT", nullable = true, length = 100)
    public String getMemberReportsCommentPostit() {
        return memberReportsCommentPostit;
    }

    public void setMemberReportsCommentPostit(String memberReportsCommentPostit) {
        this.memberReportsCommentPostit = memberReportsCommentPostit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberReportsComment that = (MemberReportsComment) o;
        return commentId == that.commentId &&
                memberId == that.memberId &&
                Objects.equals(memberReportsCommentDate, that.memberReportsCommentDate) &&
                Objects.equals(memberReportsCommentPostit, that.memberReportsCommentPostit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, memberId, memberReportsCommentDate, memberReportsCommentPostit);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMENT_ID", referencedColumnName = "COMMENT_ID", nullable = false)
    public Comment getCommentByCommentId() {
        return commentByCommentId;
    }

    public void setCommentByCommentId(Comment commentByCommentId) {
        this.commentByCommentId = commentByCommentId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }
}
