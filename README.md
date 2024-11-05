To-Do List Project
A simple RESTful To-Do List application built with Spring Boot. This project allows users to create, update, and manage tasks with priorities and statuses, while maintaining a relationship between users and tasks.

Features
User Management: Associate tasks with specific users.
Task Management: Create, update, retrieve, and delete tasks.
Task Prioritization: Set priority levels (e.g., LOW, MEDIUM, HIGH).
Task Status Tracking: Track task statuses (e.g., PENDING, COMPLETED).
Validation: Enforce validation on task properties.
Exception Handling: Handle invalid inputs and errors gracefully.
Tech Stack
Java: Programming language.
Spring Boot: Framework for building the application.
JPA/Hibernate: For database interaction.
MySQL: Relational database management.
Lombok: To reduce boilerplate code.
JSON: API response format.
Setup
Prerequisites
Java 11 or higher
MySQL
Maven
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/yourusername/todo-list-project.git
Configure the database:

Create a new MySQL database (e.g., todo_db).
Update application.properties with your database credentials:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
Build and run the application:

bash
Copy code
mvn clean install
mvn spring-boot:run
API Endpoints
User Endpoints
POST /api/users: Create a new user.
GET /api/users: Retrieve all users.
GET /api/users/{id}: Retrieve a user by ID (includes their tasks).
PUT /api/users/{id}: Update a user.
DELETE /api/users/{id}: Delete a user.
Task Endpoints
POST /api/tasks: Create a new task.
GET /api/tasks: Retrieve all tasks.
GET /api/tasks/{id}: Retrieve a task by ID.
PUT /api/tasks/{id}: Update a task.
DELETE /api/tasks/{id}: Delete a task.
GET /api/tasks/byPriority/{priority}: Retrieve tasks filtered by priority.
Sample Request & Response
Create a Task
Request: POST /api/tasks

json
Copy code
{
  "description": "Finish project report",
  "userId": 1,
  "priority": "HIGH",
  "status": "PENDING",
  "dueDate": "2024-12-15"
}
Response:

json
Copy code
{
  "id": 10,
  "description": "Finish project report",
  "user": {
    "id": 1,
    "username": "johndoe",
    "email": "johndoe@example.com"
  },
  "dateCreated": "2024-11-04",
  "priority": "HIGH",
  "status": "PENDING",
  "dueDate": "2024-12-15"
}
Validation Rules
Task Description: Cannot be null.
User: Each task must be associated with a valid user.
Due Date: Must be in the future or present.
Priority and Status: Must be a valid enum value.
Project Structure
css
Copy code
src
├── main
│   ├── java
│   │   └── com.sangura.to_do_list
│   │       ├── controller
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       ├── service
│   │       └── dto
│   └── resources
│       ├── application.properties
│       └── data.sql
└── test
Future Improvements
Add user authentication and authorization.
Extend task filters (e.g., filter by due date).
Add sorting and pagination to endpoints.
Introduce task reminders or notifications.
Contributing
Fork the project
Create your feature branch (git checkout -b feature/YourFeature)
Commit your changes (git commit -m 'Add YourFeature')
Push to the branch (git push origin feature/YourFeature)
Open a pull request
License
This project is licensed under the MIT License.

