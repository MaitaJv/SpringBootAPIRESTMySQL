package portfolio.backend.springboot.api_rest_mysql.services.project.Impl;

import org.springframework.stereotype.Service;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectResponse;
import portfolio.backend.springboot.api_rest_mysql.repositories.project.IProjectRepository;
import portfolio.backend.springboot.api_rest_mysql.services.project.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
  private final IProjectRepository projectRepository;

  public ProjectServiceImpl(IProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  public List<ProjectResponse> findAll() {
    return projectRepository.findAll();
  }

  @Override
  public ProjectResponse findById(Long id) {
    return null;
  }

  @Override
  public ProjectResponse create(ProjectRequest project) {
    return null;
  }

  @Override
  public ProjectResponse updateById(Long id, ProjectRequest project) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }

  public ProjectResponse mapResponse(){
    return new ProjectResponse(

    );
  }
}
