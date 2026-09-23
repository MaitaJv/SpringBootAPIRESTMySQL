package portfolio.backend.springboot.api_rest_mysql.services.user.Impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portfolio.backend.springboot.api_rest_mysql.dto.user.UserRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.user.UserResponse;
import portfolio.backend.springboot.api_rest_mysql.models.entities.user.User;
import portfolio.backend.springboot.api_rest_mysql.repositories.user.IUserRepository;
import portfolio.backend.springboot.api_rest_mysql.services.project.ProjectService;
import portfolio.backend.springboot.api_rest_mysql.services.user.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private final IUserRepository userRepository;
  private final ProjectService projectService;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(IUserRepository userRepository, ProjectService projectService, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.projectService = projectService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserResponse register(UserRequest user) {
    if (userRepository.existsByName(user.name())) {
      throw new RuntimeException("El usuario ya existe");
    }
    return mapResponse(userRepository.save(mapUser(user)));
  }

  @Override
  public UserResponse logIn(UserRequest user) {
    return null;
  }

  public User mapUser(UserRequest user) {
    return new User(
        null,
        user.name(),
        passwordEncoder.encode(user.password()),
        List.of()
    );
  }

  public UserResponse mapResponse(User user) {
    return new UserResponse(
        user.getName(),
        user.getProjects().stream().map(projectService::mapResponse).toList()
    );
  }
}