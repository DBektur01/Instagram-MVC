package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Image;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserInfoRepository;
import peaksoft.service.UserInfoService;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    @Override
    public String saveUserInfo(Long userId, UserInfo newUserInfo) {
        return userInfoRepository.saveUserInfo(userId,newUserInfo);
    }

    @Override
    public UserInfo findUserInfoByUserId(Long userId) {
        return userInfoRepository.findUserInfoByUserId(userId);
    }

    @Override
    public UserInfo updateUserInfoById(Long oldUsrInfoId, UserInfo newUserInfo) {
        return userInfoRepository.updateUserInfoById(oldUsrInfoId,newUserInfo);
    }

    @Override
    public Image changeImage(Long imageId, String newImage) {
        return userInfoRepository.changeImage(imageId,newImage);
    }

    @Override
    public String deletedImageById(Long imageId) {
        return "";
    }
}
