# REST API in Java with Spring Boot

This project is a simple REST API created with Spring Boot that allows managing the USER domain, specifically for the DELETE microservice. The API offers the basic operation such as deleting a user, displaying the SWAGGER documentation technology screen as the main page.
## Project Structure

- **`DeleteUserApplication.java`**: The main class that runs the Spring Boot application and defines the API controller.

- `DELETE /api/users/delete/{id}`: Allows you to delete the user, under the required ID.

## Requirements

- **JDK 17** o superior.
- **Maven** (for dependency management and project construction).

## Installation

1. **Clone the repository**

    ```bash
    git clone <https://github.com/kevinseya/microservicio-logistic-delete-user.git>
    ```

2. **Build and run the application** with Maven:

    ```bash
    mvn spring-boot:run
    ```

3. The application run on: `http://localhost:8080`.

## Use of Endpoint

### 1. DELETE /api/users/delete/{id}

Delete a user. The request body must contain the user ID details in JSON format.
DELETE request example:
```bash
DELETE /api/users/delete/{id} Content-Type: application/json
    
    { 
    "id": "550e8400-e29b-41d4-a716-446655440000",
    }
```
**Response:**
```plaintext
    {
        User deleted successfully.
    }
```
**Response code:**

- **`200 Updated:`** User created successfully.
- **`404 Not Found:`** User not found.
- **`500 Internal Server Error:`** Server error.
