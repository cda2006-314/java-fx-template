package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.MemberReportsComment;

public interface MemberReportsCommentRepository extends JpaRepository<MemberReportsComment, Integer> {
}
