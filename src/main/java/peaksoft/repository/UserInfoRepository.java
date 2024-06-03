package peaksoft.repository;

import peaksoft.entities.Image;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface UserInfoRepository {

    String saveUserInfo(Long userId, UserInfo newUserInfo);
    UserInfo findUserInfoByUserId(Long userId);
    UserInfo updateUserInfoById(Long oldUsrInfoId,UserInfo newUserInfo);
    void deleteUserInfoById(Long userInfoId);
    Image changeImage(Long imageId,String newImage);
    String deletedImageById(Long userIngo,Long imageId);


}
