package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.back.back.model.Commentstatus;

public interface CommentstatusRepository extends JpaRepository<Commentstatus, Integer> {

    public String UPDATE_COMMENTSTATUS = "UPDATE COMMENT_HAS_COMMENTSTATUS u set COMMENTSTATUS_ID where m.COMMENT_ID = ?";

    @Query(value = UPDATE_COMMENTSTATUS, nativeQuery = true)
    public void updateCommentStatus (int commentId);
}

