package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_LIKES_COMMENT", schema = "dbo")
@IdClass(MemberLikesCommentPK.class)
public class MemberLikesComment {
    private int memberId;
    private int commentId;
    private Timestamp memberLikesCommentDate;
    private Member memberByMemberId;
    private Comment commentByCommentId;

    @Id
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Id
    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "MEMBER_LIKES_COMMENT_DATE", nullable = true)
    public Timestamp getMemberLikesCommentDate() {
        return memberLikesCommentDate;
    }

    public void setMemberLikesCommentDate(Timestamp memberLikesCommentDate) {
        this.memberLikesCommentDate = memberLikesCommentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberLikesComment that = (MemberLikesComment) o;
        return memberId == that.memberId &&
                commentId == that.commentId &&
                Objects.equals(memberLikesCommentDate, that.memberLikesCommentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, commentId, memberLikesCommentDate);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMENT_ID", referencedColumnName = "COMMENT_ID", nullable = false)
    public Comment getCommentByCommentId() {
        return commentByCommentId;
    }

    public void setCommentByCommentId(Comment commentByCommentId) {
        this.commentByCommentId = commentByCommentId;
    }
}
