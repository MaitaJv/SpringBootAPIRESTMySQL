package portfolio.backend.springboot.api_rest_mysql.models.entities.task;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import portfolio.backend.springboot.api_rest_mysql.models.entities.project.Project;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "project_id", nullable = false)
  private Project project;

  @Column(nullable = false)
  private String title;

  @Column
  private String description;

  @Enumerated(EnumType.STRING)
  @Column
  private PRIORITY priority;

  @Column
  private LocalDate deadline;

  @Enumerated(EnumType.STRING)
  @Column
  private TASK_STATE task_state;

  public Task(Long id, Project project, String title, String description, PRIORITY priority, LocalDate deadline) {
    this.id = id;
    this.project = project;
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.deadline = deadline;
    this.task_state = TASK_STATE.NOT_STARTED;
  }

  public void start() {
    this.task_state = TASK_STATE.IN_PROCESS;
  }

  public void finish() {
    this.task_state = TASK_STATE.FINISHED;
  }

  public void complete() {
    this.task_state = TASK_STATE.COMPLETED;
  }

  public Boolean expired() {
    // Se usa LocalDate.now() en lugar de new LocalDate()
    return deadline.isBefore(LocalDate.now());
  }
}