package peaksoft.repository.repositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Post createPost(Long userId,Post newPost) {
        return null;
    }

    @Override
    public Post updatePostById(Long oldPostId, Post newPost) {
        return entityManager.find(Post.class, oldPostId);
    }

    @Override
    public Post getPostById(Long postId) {
        return entityManager.find(Post.class, postId);


//        try{
//            Post post = entityManager.find(Post.class,postId);
//            if (post!=null){
//                return post;
//            }
//            throw new MyException("Post with %d not found !");
//
//        }catch (MyException e){
//            throw new RuntimeException(e.getMessage());
//        }
    }

    @Override
    public String deletePostById(Long postId){
        entityManager.remove(entityManager.find(Post.class, postId));
        return "Successfully deleted";
    }
}
