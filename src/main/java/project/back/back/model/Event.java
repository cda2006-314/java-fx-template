package project.back.back.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Event {
    private int eventId;
    private int memberId;
    private String eventLabel;
    private int eventLikes;
    private String eventPostit;
    private boolean eventIssponsored;
    private Collection<Comment> commentsByEventId;
    private Collection<Datechart> datechartsByEventId;
    private Collection<EmployeeModeratesEvent> employeeModeratesEventsByEventId;
    private Member memberByMemberId;
    private Collection<EventHasEventstatus> eventHasEventstatusesByEventId;
    private Collection<EventHasKeyword> eventHasKeywordsByEventId;
    private Collection<EventHasMedia> eventHasMediaByEventId;
    private Collection<EventHasVisibility> eventHasVisibilitiesByEventId;
    private Collection<MemberLikesEvent> memberLikesEventsByEventId;
    private Collection<MemberReportsEvent> memberReportsEventsByEventId;
    private Collection<TeamAccessesEvent> teamAccessesEventsByEventId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
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
    @Column(name = "EVENT_LABEL", nullable = false, length = 100)
    public String getEventLabel() {
        return eventLabel;
    }

    public void setEventLabel(String eventLabel) {
        this.eventLabel = eventLabel;
    }

    @Basic
    @Column(name = "EVENT_LIKES", nullable = false)
    public int getEventLikes() {
        return eventLikes;
    }

    public void setEventLikes(int eventLikes) {
        this.eventLikes = eventLikes;
    }

    @Basic
    @Column(name = "EVENT_POSTIT", nullable = true, length = 1000)
    public String getEventPostit() {
        return eventPostit;
    }

    public void setEventPostit(String eventPostit) {
        this.eventPostit = eventPostit;
    }

    @Basic
    @Column(name = "EVENT_ISSPONSORED", nullable = false)
    public boolean isEventIssponsored() {
        return eventIssponsored;
    }

    public void setEventIssponsored(boolean eventIssponsored) {
        this.eventIssponsored = eventIssponsored;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId == event.eventId &&
                memberId == event.memberId &&
                eventLikes == event.eventLikes &&
                eventIssponsored == event.eventIssponsored &&
                Objects.equals(eventLabel, event.eventLabel) &&
                Objects.equals(eventPostit, event.eventPostit);
    }

    @Override
    public String toString() {
        return eventLabel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, memberId, eventLabel, eventLikes, eventPostit, eventIssponsored);
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<Comment> getCommentsByEventId() {
        return commentsByEventId;
    }

    public void setCommentsByEventId(Collection<Comment> commentsByEventId) {
        this.commentsByEventId = commentsByEventId;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<Datechart> getDatechartsByEventId() {
        return datechartsByEventId;
    }

    public void setDatechartsByEventId(Collection<Datechart> datechartsByEventId) {
        this.datechartsByEventId = datechartsByEventId;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<EmployeeModeratesEvent> getEmployeeModeratesEventsByEventId() {
        return employeeModeratesEventsByEventId;
    }

    public void setEmployeeModeratesEventsByEventId(Collection<EmployeeModeratesEvent> employeeModeratesEventsByEventId) {
        this.employeeModeratesEventsByEventId = employeeModeratesEventsByEventId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<EventHasEventstatus> getEventHasEventstatusesByEventId() {
        return eventHasEventstatusesByEventId;
    }

    public void setEventHasEventstatusesByEventId(Collection<EventHasEventstatus> eventHasEventstatusesByEventId) {
        this.eventHasEventstatusesByEventId = eventHasEventstatusesByEventId;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<EventHasKeyword> getEventHasKeywordsByEventId() {
        return eventHasKeywordsByEventId;
    }

    public void setEventHasKeywordsByEventId(Collection<EventHasKeyword> eventHasKeywordsByEventId) {
        this.eventHasKeywordsByEventId = eventHasKeywordsByEventId;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<EventHasMedia> getEventHasMediaByEventId() {
        return eventHasMediaByEventId;
    }

    public void setEventHasMediaByEventId(Collection<EventHasMedia> eventHasMediaByEventId) {
        this.eventHasMediaByEventId = eventHasMediaByEventId;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<EventHasVisibility> getEventHasVisibilitiesByEventId() {
        return eventHasVisibilitiesByEventId;
    }

    public void setEventHasVisibilitiesByEventId(Collection<EventHasVisibility> eventHasVisibilitiesByEventId) {
        this.eventHasVisibilitiesByEventId = eventHasVisibilitiesByEventId;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<MemberLikesEvent> getMemberLikesEventsByEventId() {
        return memberLikesEventsByEventId;
    }

    public void setMemberLikesEventsByEventId(Collection<MemberLikesEvent> memberLikesEventsByEventId) {
        this.memberLikesEventsByEventId = memberLikesEventsByEventId;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<MemberReportsEvent> getMemberReportsEventsByEventId() {
        return memberReportsEventsByEventId;
    }

    public void setMemberReportsEventsByEventId(Collection<MemberReportsEvent> memberReportsEventsByEventId) {
        this.memberReportsEventsByEventId = memberReportsEventsByEventId;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<TeamAccessesEvent> getTeamAccessesEventsByEventId() {
        return teamAccessesEventsByEventId;
    }

    public void setTeamAccessesEventsByEventId(Collection<TeamAccessesEvent> teamAccessesEventsByEventId) {
        this.teamAccessesEventsByEventId = teamAccessesEventsByEventId;
    }
}
