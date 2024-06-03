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
    private final User currentUser;



    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("newUser",new User());
        return "user/signUp";
    }


    @PostMapping("/signUp")
    public String singUp(@ModelAttribute("newUser")User user){
        userService.singUp(user);
        return "redirect:/auth/homePage";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginUser",new User());
        return "user/signIn";
    }

    @PostMapping("/signUser")
    public String signIn(@ModelAttribute("loginUser") User newUser, Model model) {
         model.addAttribute("singIn",userService.singIn(newUser));
        return "/user/homePage2";
    }

    @GetMapping("/profile")
    public String profile() {
        return "user/profile";
    }

}
