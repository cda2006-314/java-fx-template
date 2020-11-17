package project.back.back.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import project.back.back.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.repository.CommentRepository;


@Service
public class CommentServices {

@Autowired
CommentRepository commentRepository;

    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    public int hasLike(Integer commentId) {
        return commentRepository.findHisLike(commentId);
    }

    public void isLike(Integer commentId) {
        commentRepository.isLiked(commentId);
    }

    public void isReported(Integer commentId) {
        if (commentRepository.isModerated(commentId)) {
            System.out.println("Ce commentaire a été signalé");
            //revenir quand la table de modération des employés aura été organisé.
        }

    }
public void moderateComment(Integer memberId, Integer commentId){commentRepository.moderateComment(memberId, commentId);}
}
