package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.back.back.model.Member;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Integer> {



    Member findMemberByMemberId(Integer memberId);

    Member findMemberByMemberEmail(String email);

    Member findMemberByMemberUsername(String username);





}
