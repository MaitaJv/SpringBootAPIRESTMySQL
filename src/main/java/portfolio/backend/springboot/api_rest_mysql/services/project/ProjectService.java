package portfolio.backend.springboot.api_rest_mysql.services.project;

import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectResponse;
import portfolio.backend.springboot.api_rest_mysql.models.entities.project.Project;

import java.util.List;

public interface ProjectService {
  List<ProjectResponse> findAll(Long user_id);

  ProjectResponse findById(Long user_id, Long id);

  ProjectResponse create(ProjectRequest project, Long user_id);

  ProjectResponse updateById(Long user_id, Long id, ProjectRequest project);

  void delete(Long user_id, Long id);

  ProjectResponse mapResponse(Project project);

}
