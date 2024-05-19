package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import peaksoft.service.PostService;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Controller
@RequiredArgsConstructor
public class PostApi {
    private PostService postService;
}
