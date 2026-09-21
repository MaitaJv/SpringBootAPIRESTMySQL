package portfolio.backend.springboot.api_rest_mysql.dto.user;

import portfolio.backend.springboot.api_rest_mysql.dto.project.ProjectResponse;

import java.util.List;

public record UserResponse(
        String name,
        List<ProjectResponse> projects
) {
}
