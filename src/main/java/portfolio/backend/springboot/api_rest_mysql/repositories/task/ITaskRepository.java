package portfolio.backend.springboot.api_rest_mysql.repositories.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.backend.springboot.api_rest_mysql.models.entities.task.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
}
