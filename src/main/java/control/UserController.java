package control;

import Service.UserService;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService = new UserService();

    @GetMapping("/addUser")
    public void addUser(String firstName, String secondName, String email) {
        User user = new User();
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setEmail(email);

        userService.addUserService(user);
    }
}
