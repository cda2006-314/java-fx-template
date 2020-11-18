package project.back.back.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_REPORTS_EVENT", schema = "dbo")
@IdClass(MemberReportsEventPK.class)
public class MemberReportsEvent {
    private int eventId;
    private int memberId;
    private Timestamp memberReportsEventDate;
    private String memberReportsEventPostit;
    private Event eventByEventId;
    private Member memberByMemberId;

    @Id
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
    @Column(name = "MEMBER_REPORTS_EVENT_DATE", nullable = true)
    public Timestamp getMemberReportsEventDate() {
        return memberReportsEventDate;
    }

    public void setMemberReportsEventDate(Timestamp memberReportsEventDate) {
        this.memberReportsEventDate = memberReportsEventDate;
    }

    @Basic
    @Column(name = "MEMBER_REPORTS_EVENT_POSTIT", nullable = true, length = 200)
    public String getMemberReportsEventPostit() {
        return memberReportsEventPostit;
    }

    public void setMemberReportsEventPostit(String memberReportsEventPostit) {
        this.memberReportsEventPostit = memberReportsEventPostit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberReportsEvent that = (MemberReportsEvent) o;
        return eventId == that.eventId &&
                memberId == that.memberId &&
                Objects.equals(memberReportsEventDate, that.memberReportsEventDate) &&
                Objects.equals(memberReportsEventPostit, that.memberReportsEventPostit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, memberId, memberReportsEventDate, memberReportsEventPostit);
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
}
