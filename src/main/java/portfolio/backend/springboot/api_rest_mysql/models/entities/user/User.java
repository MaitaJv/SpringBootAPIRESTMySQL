package portfolio.backend.springboot.api_rest_mysql.models.entities.user;

import lombok.Data;
import portfolio.backend.springboot.api_rest_mysql.models.entities.project.Project;

import java.util.List;

@Data
public class User {
  private Long id;
  private String name;
  private String password;
  private List<Project> projects;

  public User(Long id, String name, String password, List<Project> projects) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.projects = projects;
  }
}
