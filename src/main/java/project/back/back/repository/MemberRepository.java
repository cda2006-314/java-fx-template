package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.back.back.model.Member;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Integer> {

    String STATUS_MEMBER = "Select m from Member m where m.MEMBER_ISVERIFIED = false";

    Member findMemberByMemberId(Integer memberId);

    @Query(value = STATUS_MEMBER, nativeQuery = true)
    List<Member> findUnverified();




}
