package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Image;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.exception.MyException;
import peaksoft.repository.UserInfoRepository;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Repository
@RequiredArgsConstructor
@Transactional
public class UserInfoRepositoryImpl implements UserInfoRepository {

 @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String saveUserInfo(Long userId, UserInfo newUserInfo) {
        User user = entityManager.find(User.class, userId);
        user.setUserInfo(newUserInfo);
        newUserInfo.setUser(user);
        entityManager.merge(newUserInfo);
        //entityManager.persist(newUserInfo);

        return "";
    }

    @Override
    public UserInfo findUserInfoByUserId(Long userId) {
        return entityManager.find(UserInfo.class,userId);
//        try {
//            UserInfo userInfo = entityManager.find(UserInfo.class, userId);
//            if (userInfo!=null) {
//                return userInfo;
//            } else {
//                throw new MyException(String.format("UserInfo with %d not found", userId));
//            }
//        } catch (MyException e) {
//            throw new RuntimeException(e.getMessage());
//        }
    }

    @Override
    public UserInfo updateUserInfoById(Long oldUsrInfoId, UserInfo newUserInfo) {
//        try {
//            UserInfo userInfo = entityManager.find(UserInfo.class, oldUsrInfoId);
//            if (userInfo == null) {
//                throw new MyException(String.format("UserInfo with %d not found ! ",oldUsrInfoId));
//            }
//            else {
        UserInfo userInfo = entityManager.find(UserInfo.class, oldUsrInfoId);
        userInfo.setFullName(newUserInfo.getFullName());
                userInfo.setImage(newUserInfo.getImage());
                userInfo.setGender(newUserInfo.getGender());
                userInfo.setBiography(newUserInfo.getBiography());
                entityManager.merge(userInfo);
               // entityManager.persist(userInfo);
                return userInfo;
//            }
//        }catch (MyException e){
//            throw new RuntimeException(e.getMessage());
//        }
    }

    @Override
    public void deleteUserInfoById(Long userInfoId) {
        entityManager.remove(findUserInfoByUserId(userInfoId));
//        try {
//            UserInfo userInfo = entityManager.find(UserInfo.class, userInfoId);
//            if (userInfo!=null) {
//                entityManager.remove(userInfoId);
//            } else {
//                throw new MyException(String.format("UserInfo with %d not found !", userInfoId));
//            }
//        } catch (MyException e) {
//            System.out.println(e.getMessage());
//        }

    }


    @Override
    public Image changeImage(Long imageId, String newImage) {
        UserInfo userInfo = entityManager.find(UserInfo.class, imageId);
        userInfo.setImage(newImage);
        return null;
    }

    @Override
    public String deletedImageById(Long userInfoId ,Long imageId) {
        UserInfo userInfo = entityManager.find(UserInfo.class, userInfoId);
        entityManager.remove(userInfo.getImage());
        return "Success";
    }
}
