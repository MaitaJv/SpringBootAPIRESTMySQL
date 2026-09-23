package portfolio.backend.springboot.api_rest_mysql.services.task;

import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskResponse;
import portfolio.backend.springboot.api_rest_mysql.models.entities.task.Task;

import java.util.List;

public interface TaskService {
  List<TaskResponse> findAll(Long idProject);

  TaskResponse findById(Long idProject, Long idTask);

  TaskResponse create(Long idProject, TaskRequest task);

  TaskResponse update(Long idProject, Long idTask, TaskRequest task);

  TaskResponse mapResponse(Task task);

  void delete(Long idProject, Long idTask);
}
