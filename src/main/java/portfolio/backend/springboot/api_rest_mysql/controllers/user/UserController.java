package portfolio.backend.springboot.api_rest_mysql.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolio.backend.springboot.api_rest_mysql.dto.user.UserRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.user.UserResponse;
import portfolio.backend.springboot.api_rest_mysql.services.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public UserResponse logIn(@RequestBody UserRequest user){
    return userService.logIn(user);
  }

  @PostMapping("/register")
  public UserResponse register(@RequestBody UserRequest user){
    return userService.register(user);
  }
}
