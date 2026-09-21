package portfolio.backend.springboot.api_rest_mysql.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.backend.springboot.api_rest_mysql.models.entities.user.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
