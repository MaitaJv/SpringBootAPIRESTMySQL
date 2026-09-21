package portfolio.backend.springboot.api_rest_mysql.models.entities.project;

import lombok.Data;
import portfolio.backend.springboot.api_rest_mysql.models.entities.task.Task;

import java.util.List;

@Data
public class Project {
  private Long id;
  private String title;
  private String description;
  private List<Task> tasks;

  public Project(Long id, String title, String description, List<Task> tasks) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.tasks = tasks;
  }
}
