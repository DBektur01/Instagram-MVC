package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Follower;
import peaksoft.entities.User;
import peaksoft.repository.FollowerRepository;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Repository
@RequiredArgsConstructor
@Transactional
public class FollowerRepositoryImpl implements FollowerRepository {

    private EntityManager entityManager;

    @Override
    public List<User> searchUserByName(String userName) {
        return null;
    }

    @Override
    public User subscribe() {
        return null;
    }

    @Override
    public List<Follower> getAllSubscribersByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Follower> getAllSubscriptionsByUserId(Long userId) {
        return null;
    }
}
