package peaksoft.service;

import peaksoft.entities.User;
import peaksoft.entities.UserInfo;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface UserService {
    String singUp(User newUser);
    String singIn(User oldUser);

    UserInfo userProfile(UserInfo userInfo);
    User findUserById(Long userId);
    List<User> finAllUsers();
    void deleteUserById(Long userId);


    User searchUserByName(String userName);
}
