package portfolio.backend.springboot.api_rest_mysql.controllers.project;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectResponse;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskResponse;
import portfolio.backend.springboot.api_rest_mysql.services.project.ProjectService;
import portfolio.backend.springboot.api_rest_mysql.services.task.TaskService;

import java.util.List;

@Controller
@RequestMapping("/{user_id}/project")
public class ProjectController {
  private final ProjectService projectService;
  private final TaskService taskService;


  public ProjectController(ProjectService projectService, TaskService taskService) {
    this.projectService = projectService;
    this.taskService = taskService;
  }

  @GetMapping
  public List<ProjectResponse> findAll(){
    return  projectService.findAll();
  }

  @GetMapping("/{id}")
  public ProjectResponse findById(@RequestParam Long id){
    return  projectService.findById(id);
  }

  @PostMapping
  public ProjectResponse create(@RequestBody ProjectRequest project, @RequestParam Long user_id){
    return projectService.create(project, user_id);
  }

  @PutMapping("/{id}")
  public ProjectResponse update(@RequestParam Long id, @RequestBody ProjectRequest project){
    return projectService.updateById(id, project);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@RequestParam Long id){
    projectService.delete(id);
  }

  // ----------------------- TASKS

  @GetMapping("/{idProject}/task")
  public List<TaskResponse> findAllTask(@RequestParam Long idProject){
    return taskService.findAll(idProject);
  }

  @GetMapping("/{idProject}/task/{idTask}")
  public List<TaskResponse> findAllTask(@RequestParam Long idProject, @RequestParam Long idTask){
    return taskService.findById(idProject, idTask);
  }

  @PostMapping("/{idProject}/task")
  public List<TaskResponse> createTask(@RequestParam Long idProject, @RequestBody TaskRequest task){
    return taskService.create(idProject, task);
  }

  @PutMapping("/{idProject}/task/{idTask}")
  public List<TaskResponse> updateTask(@RequestParam Long idProject, @RequestParam Long idTask, @RequestBody TaskRequest task){
    return taskService.update(idProject, idTask, task);
  }
}
