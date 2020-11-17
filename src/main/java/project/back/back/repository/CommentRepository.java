package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.back.back.model.Comment;
import project.back.back.model.MemberReportsComment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    public static final String FIND_LIKE = "SELECT COMMENT_LIKES FROM comment c where c.COMMENT_ID = ?";
    public static final String UPDATE_LIKE = "UPDATE COMMENT set COMMENT_LIKES = COMMENT_LIKES + 1  where c.COMMENT_ID = ?";
    public static final String is_Moderated = "Select COMMENT_ID from MEMBER_REPORTS_COMMENT m where m.COMMENT_ID = ?";
    public static final String comment_Moderate = "Insert into MEMBER_REPORTS_COMMENT values (?, ?)";

    @Query(value = FIND_LIKE, nativeQuery = true)
    public int findHisLike(int commentId);

    @Query(value = UPDATE_LIKE, nativeQuery = true)
    public int isLiked(int commentId);

    @Query(value = is_Moderated, nativeQuery = true)
    public boolean isModerated(int commentId);

    @Query(value = comment_Moderate, nativeQuery = true)
    public void moderateComment(int commentId, int memberId);
}
