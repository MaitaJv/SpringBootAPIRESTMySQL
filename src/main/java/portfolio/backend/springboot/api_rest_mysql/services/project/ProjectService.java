package portfolio.backend.springboot.api_rest_mysql.services.project;

import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectRequest;
import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectResponse;

import java.util.List;

public interface ProjectService {
  List<ProjectResponse> findAll();

  ProjectResponse findById(Long id);

  ProjectResponse create(ProjectRequest project);

  ProjectResponse updateById(Long id, ProjectRequest project);

  void delete(Long id);

}
