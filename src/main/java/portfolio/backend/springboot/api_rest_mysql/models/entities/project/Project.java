package portfolio.backend.springboot.api_rest_mysql.models.entities.project;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import portfolio.backend.springboot.api_rest_mysql.models.entities.task.Task;
import portfolio.backend.springboot.api_rest_mysql.models.entities.user.User;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(nullable = false)
  private String title;

  @Column
  private String description;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Task> tasks;

  public Project(Long id, User user, String title, String description, List<Task> tasks) {
    this.id = id;
    this.user = user;
    this.title = title;
    this.description = description;
    this.tasks = tasks;
  }
}