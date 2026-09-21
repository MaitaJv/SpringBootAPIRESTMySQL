package portfolio.backend.springboot.api_rest_mysql.models.entities.task;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Task {
  private Long id;
  private String title;
  private String description;
  private PRIORITY priority;
  private LocalDate dateline;
  private TASK_STATE task_state;


  public Task(Long id, String title, String description, PRIORITY priority, LocalDate dateline) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.dateline = dateline;
    this.task_state = TASK_STATE.NOT_STARTED;
  }

  public void start(){
    this.task_state = TASK_STATE.IN_PROCESS;
  }

  public void finish(){
    this.task_state = TASK_STATE.FINISHED;
  }

  public void complete(){
    this.task_state = TASK_STATE.COMPLETED;
  }

  public Boolean expired(){
    return dateline.isBefore(LocalDate.now());
  }
}
