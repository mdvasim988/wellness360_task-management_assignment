# Task Management System API

RESTful API for a Task Management System built using **Java 17**, **Spring Boot 4**.

---

## 🚀 System Features

### 📦 Required Features
* **GET /tasks**: Retrieve all tasks from the system.
* **GET /tasks/{id}**: Retrieve a specific task using its unique ID.
* **POST /tasks**: Create a new task with validation rules.
* **PUT /tasks/{id}**: Update/replace an entire existing task's properties.
* **DELETE /tasks/{id}**: Delete a task permanently from the database.
* **PATCH /tasks/{id}/complete**: Explicitly mark an existing task's status as `completed`.

### ✨ Additional & Bonus Features (Implemented)
* **Basic Authentication**: Secured all system API endpoints using HTTP Basic Auth to safeguard private data. *(Bonus Requirement)*
* **Pagination**: Implemented Spring Data `Pageable` parameters on the collection endpoint to prevent server overhead.
* **Interactive Swagger UI Docs**: Embedded an interactive OpenApi documentation platform directly into the running instance.

---

## 🛠️ Tech Stack & Architecture
* **Language/Framework:** Java 17 / Spring Boot 4.x
* **Database:** H2 Database (In-Memory Data Store)
* **Object Mapping:** MapStruct
* **Documentation:** Springdoc OpenAPI (Swagger)

---

## ⚙️ Steps to Run

The application is structured to be completely plug-and-play with zero database setup required.

1. **Clone the repository:**
   ```bash
   git clone https://github.com/mdvasim988/wellness360_task-management_assignment.git
   cd task-management-system
   ```
2. **Open in your IDE:**
    * Import the project into **IntelliJ IDEA**, **Eclipse**, or **VS Code** as a Maven project.
3. **Run the Application:**
    * Navigate to `src/main/java/com/assignment/wellness360/task_management_system/TaskManagementSystemApplication.java`
    * Right-click and **Run the main method**. 
    * The application will start on **`http://localhost:8080`**.

---

## 🔑 Authentication & Console Credentials
The API is secured using HTTP Basic Authentication. Use these credentials to test endpoints:

* **Username:** `admin`
* **Password:** `password123`

### H2 In-Memory Database Console
* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User Name:** `sa`
* **Password:** `password`

---

## 📖 API Documentation & Endpoints

### Swagger UI (Interactive API Docs)
Once the application is running, navigate here to test the live endpoints directly from your browser:
👉 **`http://localhost:8080/swagger-ui/index.html`**

### Summary of REST Endpoints

| HTTP Method | Endpoint | Description                                   | Auth Required? |
| :--- | :--- |:----------------------------------------------| :--- |
| **GET** | `/api/tasks` | Retrieve all tasks (Supports `page`, `size`)  | Yes |
| **GET** | `/api/tasks/{id}` | Retrieve a specific task by ID                | Yes |
| **POST** | `/api/tasks` | Create a new task                             | Yes |
| **PUT** | `/api/tasks/{id}` | Replace/Update an entire existing task        | Yes |
| **PATCH** | `/api/tasks/{id}/complete` | Mark an existing task status as `completed`   | Yes |
| **DELETE** | `/api/tasks/{id}` | Erase a task from the system permanently      | Yes |

#### Sample POST / PUT Request Payload (`application/json`)
```json
{
  "title": "Review Backend Assignment",
  "description": "Check the package structure and code quality.",
  "dueDate": "2026-10-15",
  "status": "in_progress"
}
```

---

## 🕹️ How to Test and Run the Endpoints

You can interact with and test the system API endpoints using either **Swagger UI** or **Postman**.

### Option A: Using Swagger UI (Easiest)
1. Open your web browser and navigate to: **`http://localhost:8080/swagger-ui/index.html`**
2. Click the **Authorize (Lock Icon)** button in the top right corner.
3. Enter the username (`admin`) and password (`password123`) to unlock the endpoints.
4. *Alternative:* If your browser prompts you with a standard login popup window upon navigating to the URL, simply type the credentials there directly.

### Option B: Using Postman
1. Create a new request (e.g., `GET http://localhost:8080/api/tasks`).
2. Navigate to the **Authorization** tab beneath the URL bar.
3. Select **Basic Auth** from the *Type* dropdown menu.
4. Input `admin` into the Username field and `password123` into the Password field.
5. Click **Send**.

---

## 🧠 Design Decisions & Engineering Assumptions

1. **MapStruct over ModelMapper:** Switched from runtime reflection to compile-time mapping code generation using MapStruct. This resolved deep reflection warnings (`sun.misc.Unsafe`), increased runtime efficiency, and allowed compilation-level structural checks.
2. **Pagination Defaults:** If a user issues a `GET /api/tasks` request without defining explicit limits, the system assumes standard fallback query bounds (`page = 0`, `size = 10`) to prevent out-of-memory overhead.


---

## Note

1. Postman collection is attached for use.


---