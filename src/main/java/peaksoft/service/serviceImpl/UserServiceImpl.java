package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String singUp(User newUser) {
        return userRepository.singUp(newUser);
    }

    @Override
    public String singIn(User oldUser) {
        return userRepository.singIn(oldUser);
    }

    @Override
    public UserInfo userProfile(UserInfo userInfo) {
        return userRepository.userProfile(userInfo);
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public List<User> finAllUsers() {
        return null;
    }

    @Override
    public void deleteUserById(Long userId) {
         userRepository.deleteUserById(userId);
    }


    @Override
    public User searchUserByName(String userName) {
        return userRepository.searchUserByName(userName);
    }
}
