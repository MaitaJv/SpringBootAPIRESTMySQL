package portfolio.backend.springboot.api_rest_mysql.services.project.Impl;

import org.springframework.stereotype.Service;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectResponse;
import portfolio.backend.springboot.api_rest_mysql.models.entities.project.Project;
import portfolio.backend.springboot.api_rest_mysql.models.entities.user.User;
import portfolio.backend.springboot.api_rest_mysql.repositories.project.IProjectRepository;
import portfolio.backend.springboot.api_rest_mysql.repositories.user.IUserRepository;
import portfolio.backend.springboot.api_rest_mysql.services.project.ProjectService;
import portfolio.backend.springboot.api_rest_mysql.services.task.TaskService;

import java.util.List;
import java.util.Objects;

@Service
public class ProjectServiceImpl implements ProjectService {
  private final IProjectRepository projectRepository;
  private final TaskService taskService;
  private final IUserRepository userRepository;

  public ProjectServiceImpl(IProjectRepository projectRepository, TaskService taskService, IUserRepository userRepository) {
    this.projectRepository = projectRepository;
    this.taskService = taskService;
    this.userRepository = userRepository;
  }

  @Override
  public List<ProjectResponse> findAll(Long user_id) {
    User user = userRepository.findById(user_id).orElseThrow();
    return user.getProjects().stream().map(this::mapResponse).toList();
  }

  @Override
  public ProjectResponse findById(Long user_id, Long id) {
    User user = userRepository.findById(user_id).orElseThrow();
    Project project = user.getProjects().stream().filter(p-> Objects.equals(p.getId(), id)).toList().getFirst();
    return mapResponse(project);
  }

  @Override
  public ProjectResponse create(ProjectRequest project, Long user_id) {
    Project new_project = this.mapProject(project, user_id);
    projectRepository.save(new_project);

    User user = userRepository.findById(user_id).orElseThrow();
    user.getProjects().add(new_project);
    userRepository.save(user);

    return mapResponse(new_project);
  }

  @Override
  public ProjectResponse updateById(Long user_id, Long id, ProjectRequest project) {
    User user = userRepository.findById(user_id).orElseThrow();


    Project new_project = user.getProjects().stream().filter(p-> Objects.equals(p.getId(), id)).toList().getFirst();

    new_project.setTitle(project.title());
    new_project.setDescription(project.description());

    userRepository.save(user);

    return mapResponse(projectRepository.save(new_project));
  }

  @Override
  public void delete(Long user_id, Long id) {
    User user = userRepository.findById(user_id).orElseThrow();

    Project deleted_project = user.getProjects().stream().filter(p-> Objects.equals(p.getId(), id)).toList().getFirst();
    projectRepository.delete(deleted_project);
  }

  public Project mapProject(ProjectRequest projectResponse, Long user_id){
    return new Project(
            null,
            userRepository.findById(user_id).orElseThrow(),
            projectResponse.title(),
            projectResponse.description(),
            List.of()
    );
  }

  @Override
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
