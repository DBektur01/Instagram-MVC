package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Comment;
import peaksoft.entities.Post;
import peaksoft.repository.CommentRepository;
import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Repository
@RequiredArgsConstructor
@Transactional
public class CommentRepositoryImpl implements CommentRepository {
    private final EntityManager entityManager;
    @Override
    public String save(Long userId, Post postId, Comment comment) {
        return "";
    }

    @Override
    public List<Comment> findAllCommentByPostId(Long postId) {
        return null;
    }

    @Override
    public String deleteCommentById(Long commentId) {
        return "";
    }


}
