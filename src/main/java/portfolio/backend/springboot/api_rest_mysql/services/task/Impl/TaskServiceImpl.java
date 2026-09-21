package portfolio.backend.springboot.api_rest_mysql.services.task.Impl;

import org.springframework.stereotype.Service;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskResponse;
import portfolio.backend.springboot.api_rest_mysql.services.task.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
  @Override
  public List<TaskResponse> findAll(Long idProject) {
    return List.of();
  }

  @Override
  public List<TaskResponse> findById(Long idProject, Long idTask) {
    return List.of();
  }

  @Override
  public List<TaskResponse> create(Long idProject, TaskRequest task) {
    return List.of();
  }

  @Override
  public List<TaskResponse> update(Long idProject, Long idTask, TaskRequest task) {
    return List.of();
  }
}
