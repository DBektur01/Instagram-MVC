package peaksoft.service.serviceImpl;

import org.springframework.stereotype.Service;
import peaksoft.entities.Comment;
import peaksoft.entities.Post;
import peaksoft.service.CommentService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Service
public class CommentServiceImpl implements CommentService {
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
