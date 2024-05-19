package peaksoft.repository.repositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Post;
import peaksoft.exception.MyException;
import peaksoft.repository.PostRepository;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Repository
@RequiredArgsConstructor
@Transactional
public class PostRepositoryImpl implements PostRepository {

    private final EntityManager entityManager;

    @Override
    public Post createPost(Long userId,Post newPost) {

        return null;
    }

    @Override
    public Post updatePostById(Long oldPostId, Post newPost) {
        return null;
    }

    @Override
    public Post getPostById(Long postId) {
        try{
            Post post = entityManager.find(Post.class,postId);
            if (post!=null){
                return post;
            }
            else {
                throw new MyException("Post with %d not found !");
            }
        }catch (MyException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String deletePostById(Long postId){
        Post post = entityManager.find(Post.class, postId);
        entityManager.remove(post);
        return "Successfully deleted";
    }
}
