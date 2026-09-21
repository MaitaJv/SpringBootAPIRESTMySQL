package portfolio.backend.springboot.api_rest_mysql.services.user;

import portfolio.backend.springboot.api_rest_mysql.dto.user.UserRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.user.UserResponse;

public interface UserService {
  UserResponse register(UserRequest user);

  UserResponse logIn(UserRequest user);
}
