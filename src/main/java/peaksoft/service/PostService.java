package peaksoft.service;

import peaksoft.entities.Image;
import peaksoft.entities.Like;
import peaksoft.entities.Post;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface PostService {
    Post createPost(Long userId,Post newPost);
    Post updatePostById(Long oldPostId,Post newPost);
    Post getPostById(Long post);
    String deletePostById(Long postId);
}
