package portfolio.backend.springboot.api_rest_mysql.services.task;

import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskResponse;

import java.util.List;

public interface TaskService {
  List<TaskResponse> findAll(Long idProject);

  List<TaskResponse> findById(Long idProject, Long idTask);

  List<TaskResponse> create(Long idProject, TaskRequest task);

  List<TaskResponse> update(Long idProject, Long idTask, TaskRequest task);

}
