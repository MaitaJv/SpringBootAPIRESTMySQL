package portfolio.backend.springboot.api_rest_mysql.models.entities.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import portfolio.backend.springboot.api_rest_mysql.models.entities.project.Project;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(nullable = false)
  private String password;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Project> projects;

  public User(Long id, String name, String password, List<Project> projects) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.projects = projects;
  }
}