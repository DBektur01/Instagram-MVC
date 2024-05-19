package peaksoft.repository;

import peaksoft.entities.Comment;
import peaksoft.entities.Post;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface CommentRepository {

    String save(Long userId, Post postId, Comment comment);

    List<Comment> findAllCommentByPostId(Long postId);
    String deleteCommentById(Long commentId);
}
