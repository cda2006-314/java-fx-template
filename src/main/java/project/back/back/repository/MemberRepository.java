package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Member;

import javax.persistence.criteria.CriteriaBuilder;


public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findMemberByMemberId(Integer memberId);
}
