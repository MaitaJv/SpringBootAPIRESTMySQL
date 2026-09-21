package portfolio.backend.springboot.api_rest_mysql.dto.task;

import portfolio.backend.springboot.api_rest_mysql.models.entities.task.PRIORITY;
import portfolio.backend.springboot.api_rest_mysql.models.entities.task.TASK_STATE;

import java.time.LocalDate;

public record TaskResponse(
        Long id,
        Long project_id,
        String title,
        String description,
        PRIORITY priority,
        LocalDate deadline,
        TASK_STATE task_state
) {
}
