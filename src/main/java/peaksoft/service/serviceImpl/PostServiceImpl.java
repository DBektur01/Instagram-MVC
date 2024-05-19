package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Post;
import peaksoft.repository.PostRepository;
import peaksoft.service.PostService;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    @Override
    public Post getPostById(Long post) {
        return null;
    }

    @Override
    public String deletePostById(Long postId) {
        return "";
    }

    private PostRepository postRepository;

    @Override
    public Post createPost(Long userId,Post newPost) {
        return null;
    }

    @Override
    public Post updatePostById(Long oldPostId, Post newPost) {
        return null;
    }
}
