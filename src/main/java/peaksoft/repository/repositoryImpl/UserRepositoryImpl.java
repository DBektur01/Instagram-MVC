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
    public String singIn(User oldUser) {
        try {
            for (User user : finAllUsers()) {
                if (user.getUserName().equals(oldUser.getUserName())
                        && user.getPassword().equals(oldUser.getPassword())) {
                    return generateAuthToken(user);
                }
            }
            throw new MyException(String.format("Not found user with %s  user name ",oldUser.getUserName()));
        } catch (MyException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public UserInfo userProfile(UserInfo userInfo) {
        return null;
    }

    @Override
    public User findUserById(Long userId) {
        try {
            User user = entityManager.find(User.class, userId);
            if (user != null) {
                return user;
            } else {
                throw new MyException(String.format("User with %d not found !", userId));
            }
        } catch (MyException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<User> finAllUsers() {
        try {
            if (finAllUsers().isEmpty()) {
                throw new MyException("FindAllUser isEmpty !");
            }
            return entityManager.createQuery("select u from User u", User.class).getResultList();

        } catch (MyException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        try {
            User user = entityManager.find(User.class, userId);
            if (user != null) {
                entityManager.remove(user);
            } else {
                throw new MyException(String.format("User with %d not found !", userId));
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public User searchUserByName(String userName) {
        try {
            if (finAllUsers().isEmpty()) {
                throw new MyException(String.format("Not found user with %s ",userName));
            }
            return entityManager.createQuery("select u from User u where u.userName like :userName", User.class)
                    .setParameter("userName", "%" + userName + "%").getSingleResult();
        }catch (MyException e){
            throw new RuntimeException(e.getMessage());

        }
    }
    private String generateAuthToken(User user) {
        return "generated_auth_token_for_" + user.getId();
    }
}
