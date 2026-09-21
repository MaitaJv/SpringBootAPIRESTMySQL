package portfolio.backend.springboot.api_rest_mysql.dto.user;

public record UserRequest(
        String name,
        String password
) {
}
