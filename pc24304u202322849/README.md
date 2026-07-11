# pc24304u202322849

Atlassian access requests REST API developed with Java 24, Spring Boot 3.5, Spring Data JPA, MySQL, DDD, CQRS and OpenAPI.

## Endpoint

`POST /api/v1/employees/{employeeId}/access-requests`

## Run

1. Configure MySQL credentials in `src/main/resources/application.properties`.
2. Run `mvn spring-boot:run`.
3. Open Swagger at `http://localhost:8080/swagger-ui.html`.
