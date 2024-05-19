package peaksoft.service;

import peaksoft.entities.Image;
import peaksoft.entities.UserInfo;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface UserInfoService {
    String saveUserInfo(Long userId, UserInfo newUserInfo);
    UserInfo findUserInfoByUserId(Long userId);
    UserInfo updateUserInfoById(Long oldUsrInfoId,UserInfo newUserInfo);
    Image changeImage(Long imageId, Image newImage);
    String deletedImageById(Long imageId);
}
