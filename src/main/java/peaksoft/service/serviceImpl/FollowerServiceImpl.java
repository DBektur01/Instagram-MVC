package peaksoft.service.serviceImpl;

import org.springframework.stereotype.Service;
import peaksoft.entities.Follower;
import peaksoft.entities.User;
import peaksoft.service.FollowerService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Service
public class FollowerServiceImpl implements FollowerService {
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
