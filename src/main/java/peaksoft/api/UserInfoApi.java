package peaksoft.api;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import peaksoft.service.UserInfoService;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Controller
@RequiredArgsConstructor
public class UserInfoApi {
    private final UserInfoService userInfoService;
}
