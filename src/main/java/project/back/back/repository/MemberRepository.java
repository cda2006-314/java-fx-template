package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Member;



public interface MemberRepository extends JpaRepository<Member, Integer> {

}
