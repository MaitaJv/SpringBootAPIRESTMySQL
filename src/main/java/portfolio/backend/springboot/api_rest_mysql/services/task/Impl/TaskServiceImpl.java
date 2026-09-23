package portfolio.backend.springboot.api_rest_mysql.services.task.Impl;

import org.springframework.stereotype.Service;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskResponse;
import portfolio.backend.springboot.api_rest_mysql.models.entities.project.Project;
import portfolio.backend.springboot.api_rest_mysql.models.entities.task.Task;
import portfolio.backend.springboot.api_rest_mysql.repositories.project.IProjectRepository;
import portfolio.backend.springboot.api_rest_mysql.repositories.task.ITaskRepository;
import portfolio.backend.springboot.api_rest_mysql.services.task.TaskService;

import java.util.List;
import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService {
  private final ITaskRepository taskRepository;
  private final IProjectRepository projectRepository;

  public TaskServiceImpl(ITaskRepository taskRepository, IProjectRepository projectRepository) {
    this.taskRepository = taskRepository;
    this.projectRepository = projectRepository;
  }

  @Override
  public List<TaskResponse> findAll(Long idProject) {
    Project project = projectRepository.findById(idProject).orElseThrow();
    return project.getTasks().stream().map(this::mapResponse).toList();
  }

  @Override
  public TaskResponse findById(Long idProject, Long idTask) {
    Project project = projectRepository.findById(idProject).orElseThrow();

    return mapResponse(project.getTasks().stream().filter(t-> Objects.equals(t.getId(), idTask)).toList().getFirst());
  }

  @Override
  public TaskResponse create(Long idProject, TaskRequest task) {
    Project project = projectRepository.findById(idProject).orElseThrow();

    Task new_task = taskRepository.save(mapTask(task, idProject));

    project.getTasks().add(new_task);
    projectRepository.save(project);

    return mapResponse(new_task);
  }

  @Override
  public TaskResponse update(Long idProject, Long idTask, TaskRequest task) {
    Project project = projectRepository.findById(idProject).orElseThrow();
    Task new_task = project.getTasks().stream().filter(t-> Objects.equals(t.getId(), idTask)).toList().getFirst();

    new_task.setTitle(task.title());
    new_task.setDescription(task.description());
    new_task.setPriority(task.priority());
    new_task.setDeadline(task.deadline());

    return mapResponse(taskRepository.save(new_task));
  }

  @Override
  public void delete(Long idProject, Long idTask) {
    Project project = projectRepository.findById(idProject).orElseThrow();
    Task deleted_task = project.getTasks().stream().filter(t-> Objects.equals(t.getId(), idTask)).toList().getFirst();
    taskRepository.delete(deleted_task);
  }

  @Override
  public TaskResponse mapResponse(Task task) {
    return new TaskResponse(
        task.getId(),
        task.getProject().getId(),
        task.getTitle(),
        task.getDescription(),
        task.getPriority(),
        task.getDeadline(),
        task.getTask_state()
    );
  }

  public Task mapTask(TaskRequest taskRequest, Long project_id){
    return new Task(
            null,
            projectRepository.findById(project_id).orElseThrow(),
            taskRequest.title(),
            taskRequest.description(),
            taskRequest.priority(),
            taskRequest.deadline()
    );
  }
}
