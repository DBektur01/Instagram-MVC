package peaksoft.api;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Controller
@RequiredArgsConstructor

@RequestMapping("/auth")
public class UserApi {

    private final UserService userService;
    private final User currentUser;



    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("newUser",new User());
        return "user/signUp";
    }


    @PostMapping("/signUp")
    public String singUp(@ModelAttribute("newUser")User user){
        userService.singUp(user);
        return "redirect:/auth/";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginUser",new User());
        return "user/signIn";
    }

    @PostMapping("/signIn")
    public String signIn(@ModelAttribute("loginUser") User newUser, Model model) {
         model.addAttribute("singIn",userService.singIn(newUser));
        return "user/profile";
    }

    @GetMapping("/profile")
    public String getUserProfile(Model model) {
        model.addAttribute("user", currentUser);
        model.addAttribute("userInfo", currentUser.getUserInfo());
        model.addAttribute("followers", currentUser.getFollower());
        model.addAttribute("image", currentUser.getUserInfo().getImage());
        List<Post> postList = new ArrayList<>();
        for (int i = currentUser.getPost().size() - 1; i >= 0; i--) {
            postList.add(currentUser.getPost().get(i));
        }
        model.addAttribute("posts", postList);
        model.addAttribute("like", currentUser.getLike());
        return "user/profile";
    }

}
