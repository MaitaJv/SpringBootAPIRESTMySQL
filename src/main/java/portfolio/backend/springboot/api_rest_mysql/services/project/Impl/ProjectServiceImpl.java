package portfolio.backend.springboot.api_rest_mysql.services.project.Impl;

import org.springframework.stereotype.Service;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectResponse;
import portfolio.backend.springboot.api_rest_mysql.models.entities.project.Project;
import portfolio.backend.springboot.api_rest_mysql.repositories.project.IProjectRepository;
import portfolio.backend.springboot.api_rest_mysql.repositories.user.IUserRepository;
import portfolio.backend.springboot.api_rest_mysql.services.project.ProjectService;
import portfolio.backend.springboot.api_rest_mysql.services.task.TaskService;
import portfolio.backend.springboot.api_rest_mysql.services.user.UserService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
  private final IProjectRepository projectRepository;
  private final TaskService taskService;
  private final IUserRepository userRepository;

  public ProjectServiceImpl(IProjectRepository projectRepository, TaskService taskService, UserService userService, IUserRepository userRepository) {
    this.projectRepository = projectRepository;
    this.taskService = taskService;
    this.userRepository = userRepository;
  }

  @Override
  public List<ProjectResponse> findAll() {
    return projectRepository.findAll().stream().map(this::mapResponse).toList();
  }

  @Override
  public ProjectResponse findById(Long id) {
    Project project = projectRepository.findById(id).orElseThrow();
    return mapResponse(project);
  }

  @Override
  public ProjectResponse create(ProjectRequest project, Long user_id) {
    return mapResponse(projectRepository.save(this.mapProject(project, user_id)));
  }

  @Override
  public ProjectResponse updateById(Long id, ProjectRequest project) {
    Project new_project = projectRepository.findByProjectId(id);

    new_project.setTitle(project.title());
    new_project.setDescription(project.description());

    return mapResponse(projectRepository.save(new_project));
  }

  @Override
  public void delete(Long id) {
    Project deleted_project = projectRepository.findByProjectId(id);
    projectRepository.delete(deleted_project);
  }

  public Project mapProject(ProjectRequest projectResponse, Long user_id){
    return new Project(
            null,
            userRepository.findByUserId(user_id),
            projectResponse.title(),
            projectResponse.description(),
            List.of()
    );
  }

  public ProjectResponse mapResponse(Project project){
    return new ProjectResponse(
      project.getId(),
      project.getUser().getId(),
      project.getTitle(),
            project.getDescription(),
            project.getTasks().stream().map(taskService::mapResponse).toList()
    );
  }
}
