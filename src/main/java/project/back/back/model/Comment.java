package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Comment {
    private int commentId;
    private int eventId;
    private int memberId;
    private String commentText;
    private int commentLikes;
    private Timestamp memberWritesCommentDate;
    private Timestamp commentIsaboutEventDate;
    private Event eventByEventId;
    private Member memberByMemberId;
    private Collection<CommentAssociatedtoMemberslist> commentAssociatedtoMemberslistsByCommentId;
    private Collection<CommentCanhaveMedia> commentCanhaveMediaByCommentId;
    private Collection<CommentHasCommentstatus> commentHasCommentstatusesByCommentId;
    private Collection<EmployeeModeratesComment> employeeModeratesCommentsByCommentId;
    private Collection<MemberLikesComment> memberLikesCommentsByCommentId;
    private Collection<MemberReportsComment> memberReportsCommentsByCommentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "EVENT_ID", insertable = false, updatable = false, nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
    @Column(name = "COMMENT_TEXT", nullable = false, length = 3000)
    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Basic
    @Column(name = "COMMENT_LIKES", nullable = false)
    public int getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(int commentLikes) {
        this.commentLikes = commentLikes;
    }

    @Basic
    @Column(name = "MEMBER_WRITES_COMMENT_DATE", nullable = true)
    public Timestamp getMemberWritesCommentDate() {
        return memberWritesCommentDate;
    }

    public void setMemberWritesCommentDate(Timestamp memberWritesCommentDate) {
        this.memberWritesCommentDate = memberWritesCommentDate;
    }

    @Basic
    @Column(name = "COMMENT_ISABOUT_EVENT_DATE", nullable = true)
    public Timestamp getCommentIsaboutEventDate() {
        return commentIsaboutEventDate;
    }

    public void setCommentIsaboutEventDate(Timestamp commentIsaboutEventDate) {
        this.commentIsaboutEventDate = commentIsaboutEventDate;
    }

    @Override
    public String toString() {
        return commentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return commentId == comment.commentId &&
                eventId == comment.eventId &&
                memberId == comment.memberId &&
                commentLikes == comment.commentLikes &&
                Objects.equals(commentText, comment.commentText) &&
                Objects.equals(memberWritesCommentDate, comment.memberWritesCommentDate) &&
                Objects.equals(commentIsaboutEventDate, comment.commentIsaboutEventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, eventId, memberId, commentText, commentLikes, memberWritesCommentDate, commentIsaboutEventDate);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", nullable = false)
    public Event getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(Event eventByEventId) {
        this.eventByEventId = eventByEventId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }

    @OneToMany(mappedBy = "commentByCommentId")
    public Collection<CommentAssociatedtoMemberslist> getCommentAssociatedtoMemberslistsByCommentId() {
        return commentAssociatedtoMemberslistsByCommentId;
    }

    public void setCommentAssociatedtoMemberslistsByCommentId(Collection<CommentAssociatedtoMemberslist> commentAssociatedtoMemberslistsByCommentId) {
        this.commentAssociatedtoMemberslistsByCommentId = commentAssociatedtoMemberslistsByCommentId;
    }

    @OneToMany(mappedBy = "commentByCommentId")
    public Collection<CommentCanhaveMedia> getCommentCanhaveMediaByCommentId() {
        return commentCanhaveMediaByCommentId;
    }

    public void setCommentCanhaveMediaByCommentId(Collection<CommentCanhaveMedia> commentCanhaveMediaByCommentId) {
        this.commentCanhaveMediaByCommentId = commentCanhaveMediaByCommentId;
    }

    @OneToMany(mappedBy = "commentByCommentId")
    public Collection<CommentHasCommentstatus> getCommentHasCommentstatusesByCommentId() {
        return commentHasCommentstatusesByCommentId;
    }

    public void setCommentHasCommentstatusesByCommentId(Collection<CommentHasCommentstatus> commentHasCommentstatusesByCommentId) {
        this.commentHasCommentstatusesByCommentId = commentHasCommentstatusesByCommentId;
    }

    @OneToMany(mappedBy = "commentByCommentId")
    public Collection<EmployeeModeratesComment> getEmployeeModeratesCommentsByCommentId() {
        return employeeModeratesCommentsByCommentId;
    }

    public void setEmployeeModeratesCommentsByCommentId(Collection<EmployeeModeratesComment> employeeModeratesCommentsByCommentId) {
        this.employeeModeratesCommentsByCommentId = employeeModeratesCommentsByCommentId;
    }

    @OneToMany(mappedBy = "commentByCommentId")
    public Collection<MemberLikesComment> getMemberLikesCommentsByCommentId() {
        return memberLikesCommentsByCommentId;
    }

    public void setMemberLikesCommentsByCommentId(Collection<MemberLikesComment> memberLikesCommentsByCommentId) {
        this.memberLikesCommentsByCommentId = memberLikesCommentsByCommentId;
    }

    @OneToMany(mappedBy = "commentByCommentId")
    public Collection<MemberReportsComment> getMemberReportsCommentsByCommentId() {
        return memberReportsCommentsByCommentId;
    }

    public void setMemberReportsCommentsByCommentId(Collection<MemberReportsComment> memberReportsCommentsByCommentId) {
        this.memberReportsCommentsByCommentId = memberReportsCommentsByCommentId;
    }
}
