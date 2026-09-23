package portfolio.backend.springboot.api_rest_mysql.controllers.project;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectResponse;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskResponse;
import portfolio.backend.springboot.api_rest_mysql.services.project.ProjectService;
import portfolio.backend.springboot.api_rest_mysql.services.task.TaskService;

import java.util.List;

@RestController
@RequestMapping("/{user_id}/project")
public class ProjectController {
  private final ProjectService projectService;
  private final TaskService taskService;


  public ProjectController(ProjectService projectService, TaskService taskService) {
    this.projectService = projectService;
    this.taskService = taskService;
  }

  @GetMapping
  public List<ProjectResponse> findAll(@PathVariable Long user_id){
    return  projectService.findAll(user_id);
  }

  @GetMapping("/{id}")
  public ProjectResponse findById(@PathVariable Long user_id, @PathVariable Long id){
    return  projectService.findById(user_id, id);
  }

  @PostMapping
  public ProjectResponse create(@RequestBody ProjectRequest project, @PathVariable Long user_id){
    return projectService.create(project, user_id);
  }

  @PutMapping("/{id}")
  public ProjectResponse update(@PathVariable Long id, @PathVariable Long user_id,  @RequestBody ProjectRequest project){
    return projectService.updateById(user_id, id, project);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable Long user_id, @PathVariable Long id){
    projectService.delete(user_id, id);
  }

  // ----------------------- TASKS

  @GetMapping("/{idProject}/task")
  public List<TaskResponse> findAllTask(@PathVariable Long idProject){
    return taskService.findAll(idProject);
  }

  @GetMapping("/{idProject}/task/{idTask}")
  public TaskResponse findTaskById(@PathVariable Long idProject, @PathVariable Long idTask){
    return taskService.findById(idProject, idTask);
  }

  @PostMapping("/{idProject}/task")
  public TaskResponse createTask(@PathVariable Long idProject, @RequestBody TaskRequest task){
    return taskService.create(idProject, task);
  }

  @PutMapping("/{idProject}/task/{idTask}")
  public TaskResponse updateTask(@PathVariable Long idProject, @PathVariable Long idTask, @RequestBody TaskRequest task){
    return taskService.update(idProject, idTask, task);
  }

  @DeleteMapping("/{idProject}/task/{idTask}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteTask(@PathVariable Long idProject, @PathVariable Long idTask){
    taskService.delete(idProject, idTask);
  }
}
