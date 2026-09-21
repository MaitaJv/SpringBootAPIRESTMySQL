package portfolio.backend.springboot.api_rest_mysql.dto.project;

import portfolio.backend.springboot.api_rest_mysql.dto.task.TaskResponse;

import java.util.List;

public record ProjectResponse(
        Long id,
        Long user_id,
        String title,
        String description,
        List<TaskResponse> tasks
) {
}
