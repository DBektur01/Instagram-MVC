package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import peaksoft.service.CommentService;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Controller
@RequiredArgsConstructor
public class CommentApi {
    private final CommentService commentService;
}
