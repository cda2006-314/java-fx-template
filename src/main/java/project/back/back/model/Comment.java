package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
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

    @Id
    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
    @Column(name = "COMMENT_TEXT", nullable = false, length = 1000)
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
}
