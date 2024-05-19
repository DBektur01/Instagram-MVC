package peaksoft.api;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entities.User;
import peaksoft.service.UserService;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {

    private final UserService userService;
    private static User user;

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("newUser",new User());
        return "user/singUp";
    }


    @PostMapping("/signUp")
    public String singUp(@ModelAttribute("newUser") User user){
        userService.singUp(user);
        return "redirect:/users";

    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginUser",new User());
        return "user/singIn";
    }

    @PostMapping("/signIn")
    public String signIn(@ModelAttribute("uuser") User newUser, Model model) {
         model.addAttribute("singIn",userService.singIn(newUser));
        if (user == null) {
            return "users/login-error";
        }
        return "users/home-page";
    }
}
