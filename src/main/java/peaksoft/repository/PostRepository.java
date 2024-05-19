package peaksoft.repository;

import peaksoft.entities.Image;
import peaksoft.entities.Like;
import peaksoft.entities.Post;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface PostRepository {

    Post createPost(Long userId,Post newPost);
    Post getPostById(Long postId);
    Post updatePostById(Long oldPostId,Post newPost);

    String deletePostById(Long postId);
}
