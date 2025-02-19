package peaksoft.repository;

import peaksoft.entities.User;
import peaksoft.entities.UserInfo;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface UserRepository {

    String singUp(User newUser);
    User singIn(User oldUser);
    UserInfo userProfile(UserInfo userInfo);
    User findUserById(Long userId);
    List<User> finAllUsers();
    void deleteUserById(Long userId);
    User updateUserById(Long userId,User newUser);

    User searchUserByName(String userName);

}
