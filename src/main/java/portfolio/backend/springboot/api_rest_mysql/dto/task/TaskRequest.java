package portfolio.backend.springboot.api_rest_mysql.dto.task;

import portfolio.backend.springboot.api_rest_mysql.models.entities.task.PRIORITY;

import java.time.LocalDate;

public record TaskRequest(
        String title,
        String description,
        PRIORITY priority,
        LocalDate deadline
) {
}
