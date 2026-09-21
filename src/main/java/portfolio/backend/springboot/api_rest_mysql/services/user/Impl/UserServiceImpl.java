package portfolio.backend.springboot.api_rest_mysql.services.user.Impl;

import org.springframework.stereotype.Service;
import portfolio.backend.springboot.api_rest_mysql.dto.user.UserRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.user.UserResponse;
import portfolio.backend.springboot.api_rest_mysql.services.user.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public UserResponse register(UserRequest user) {
    return null;
  }

  @Override
  public UserResponse logIn(UserRequest user) {
    return null;
  }
}
