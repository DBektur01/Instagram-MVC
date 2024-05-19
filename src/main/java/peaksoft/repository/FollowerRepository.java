package peaksoft.repository;

import peaksoft.entities.Follower;
import peaksoft.entities.User;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface FollowerRepository {

     List<User>searchUserByName(String userName);

    User subscribe();

    List<Follower>getAllSubscribersByUserId(Long userId);

    List<Follower>getAllSubscriptionsByUserId(Long userId);
}
