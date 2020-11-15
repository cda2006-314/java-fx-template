package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Member {
    private int memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberUsername;
    private String memberDescription;
    private String memberPicurl;
    private String memberPostit;
    private boolean memberIsverified;
    private String memberLname;
    private String memberFname;
    private String memberSiret;
    private String memberCompany;
    private String memberAddress;
    private String memberZipcode;
    private String memberCity;
    private String memberCountry;

    @Id
    @Column(name = "MEMBER_ID", nullable = false, precision = 0)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "MEMBER_EMAIL", nullable = false, length = 320)
    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    @Basic
    @Column(name = "MEMBER_PASSWORD", nullable = false, length = 2048)
    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    @Basic
    @Column(name = "MEMBER_USERNAME", nullable = false, length = 50)
    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    @Basic
    @Column(name = "MEMBER_DESCRIPTION", nullable = true, length = 500)
    public String getMemberDescription() {
        return memberDescription;
    }

    public void setMemberDescription(String memberDescription) {
        this.memberDescription = memberDescription;
    }

    @Basic
    @Column(name = "MEMBER_PICURL", nullable = false, length = 256)
    public String getMemberPicurl() {
        return memberPicurl;
    }

    public void setMemberPicurl(String memberPicurl) {
        this.memberPicurl = memberPicurl;
    }

    @Basic
    @Column(name = "MEMBER_POSTIT", nullable = true, length = 100)
    public String getMemberPostit() {
        return memberPostit;
    }

    public void setMemberPostit(String memberPostit) {
        this.memberPostit = memberPostit;
    }

    @Basic
    @Column(name = "MEMBER_ISVERIFIED", nullable = false)
    public boolean isMemberIsverified() {
        return memberIsverified;
    }

    public void setMemberIsverified(boolean memberIsverified) {
        this.memberIsverified = memberIsverified;
    }

    @Basic
    @Column(name = "MEMBER_LNAME", nullable = true, length = 100)
    public String getMemberLname() {
        return memberLname;
    }

    public void setMemberLname(String memberLname) {
        this.memberLname = memberLname;
    }

    @Basic
    @Column(name = "MEMBER_FNAME", nullable = true, length = 100)
    public String getMemberFname() {
        return memberFname;
    }

    public void setMemberFname(String memberFname) {
        this.memberFname = memberFname;
    }

    @Basic
    @Column(name = "MEMBER_SIRET", nullable = true, length = 200)
    public String getMemberSiret() {
        return memberSiret;
    }

    public void setMemberSiret(String memberSiret) {
        this.memberSiret = memberSiret;
    }

    @Basic
    @Column(name = "MEMBER_COMPANY", nullable = true, length = 200)
    public String getMemberCompany() {
        return memberCompany;
    }

    public void setMemberCompany(String memberCompany) {
        this.memberCompany = memberCompany;
    }

    @Basic
    @Column(name = "MEMBER_ADDRESS", nullable = true, length = 200)
    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    @Basic
    @Column(name = "MEMBER_ZIPCODE", nullable = true, length = 10)
    public String getMemberZipcode() {
        return memberZipcode;
    }

    public void setMemberZipcode(String memberZipcode) {
        this.memberZipcode = memberZipcode;
    }

    @Basic
    @Column(name = "MEMBER_CITY", nullable = true, length = 100)
    public String getMemberCity() {
        return memberCity;
    }

    public void setMemberCity(String memberCity) {
        this.memberCity = memberCity;
    }

    @Basic
    @Column(name = "MEMBER_COUNTRY", nullable = true, length = 50)
    public String getMemberCountry() {
        return memberCountry;
    }

    public void setMemberCountry(String memberCountry) {
        this.memberCountry = memberCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId &&
                memberIsverified == member.memberIsverified &&
                Objects.equals(memberEmail, member.memberEmail) &&
                Objects.equals(memberPassword, member.memberPassword) &&
                Objects.equals(memberUsername, member.memberUsername) &&
                Objects.equals(memberDescription, member.memberDescription) &&
                Objects.equals(memberPicurl, member.memberPicurl) &&
                Objects.equals(memberPostit, member.memberPostit) &&
                Objects.equals(memberLname, member.memberLname) &&
                Objects.equals(memberFname, member.memberFname) &&
                Objects.equals(memberSiret, member.memberSiret) &&
                Objects.equals(memberCompany, member.memberCompany) &&
                Objects.equals(memberAddress, member.memberAddress) &&
                Objects.equals(memberZipcode, member.memberZipcode) &&
                Objects.equals(memberCity, member.memberCity) &&
                Objects.equals(memberCountry, member.memberCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberEmail, memberPassword, memberUsername, memberDescription, memberPicurl, memberPostit, memberIsverified, memberLname, memberFname, memberSiret, memberCompany, memberAddress, memberZipcode, memberCity, memberCountry);
    }
}
