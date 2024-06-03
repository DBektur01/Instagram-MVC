package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.exception.MyException;
import peaksoft.repository.UserRepository;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Repository
@RequiredArgsConstructor
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public String singUp(User newUser) {
        entityManager.persist(newUser);
        return "Successfully registered!";
//        boolean isExists = false;
//        try {
//            for (User user : finAllUsers()) {
//                if (user.getUserName().equals(newUser.getUserName())) {
//                    isExists = true;
//                    break;
//                }
//            }
//            if (!isExists) {
//                entityManager.persist(newUser);
//                return "Successfully registered!";
//            }
//            throw new MyException(String.format("A user with this name %s exists in the database", newUser.getUserName()));
//        } catch (MyException e) {
//            return e.getMessage();
//        }
    }

    @Override
    public User singIn(User oldUser) {
        for (User user : finAllUsers()) {
            if (user.getUserName().equals(oldUser.getUserName())
                    && user.getPassword().equals(oldUser.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserInfo userProfile(UserInfo userInfo) {
        return null;
    }

    @Override
    public User findUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public List<User> finAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void deleteUserById(Long userId) {
        User user = entityManager.find(User.class, userId);
        entityManager.remove(user);
//        for (User user:finAllUsers()){
//            if (user.getId().equals(userId)){
//                entityManager.remove(user);
//            }
//        }
    }

    @Override
    public User updateUserById(Long userId, User newUser) {
        User user = entityManager.find(User.class, userId);

        user.setUserName(newUser.getUserName());
        user.setEmail(newUser.getEmail());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setPassword(newUser.getPassword());

        return user;
    }


    @Override
    public User searchUserByName(String userName) {
        return entityManager.find(User.class, userName);
//        for (User user:finAllUsers()){
//            if (user.getUserName().equals(userName)) {
//                return user;
//            }
//        }
    }

}
