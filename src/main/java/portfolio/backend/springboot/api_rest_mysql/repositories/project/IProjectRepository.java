package portfolio.backend.springboot.api_rest_mysql.repositories.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.backend.springboot.api_rest_mysql.models.entities.project.Project;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {
}
