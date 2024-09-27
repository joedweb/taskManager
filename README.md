
  The application will start on [<http://localhost:8080>](<http://localhost:8080>).

### API Endpoints

#### Get All Tasks

- **URL**: `/tasks`
- **Method**: `GET`
- **Description**: Retrieves a list of all tasks.

#### Get Task by ID

- **URL**: `/tasks/{id}`
- **Method**: `GET`
- **Description**: Retrieves a task by its ID.

#### Create a New Task

- **URL**: `/tasks`
- **Method**: `POST`
- **Description**: Creates a new task.
- **Request Body**:
   ```json
   {
     "title": "Task Title",
     "description": "Task Description",
     "completed": false
   }
   ```

#### Update an Existing Task

- **URL**: `/tasks/{id}`
- **Method**: `PUT`
- **Description**: Updates an existing task by ID.
- **Request Body**:
   ```json
   {
     "title": "Updated Title",
     "description": "Updated Description",
     "completed": true
   }
   ```

### Testing the API

You can use Postman, cURL, or any other REST client to test the API endpoints.

#### Examples using cURL

- **Get all tasks**:
   ```bash
   curl -X GET <http://localhost:8080/tasks>
   ```

- **Create a new task**:
   ```bash
   curl -X POST <http://localhost:8080/tasks> \\
   -H 'Content-Type: application/json' \\
   -d '{"title": "New Task", "description": "Task description", "completed": false}'
   ```

- **Get a task by ID**:
   ```bash
   curl -X GET <http://localhost:8080/tasks/1>
   ```

- **Update a task**:
   ```bash
   curl -X PUT <http://localhost:8080/tasks/1> \\
   -H 'Content-Type: application/json' \\
   -d '{"title": "Updated Task", "description": "Updated description", "completed": true}'
   ```

### Notes

- **Data Persistence**: All data is stored in memory. Restarting the application will reset the data.
- **Date Fields**: The `createDate` is set automatically when a task is created. The `completedDate` is set when a task’s completed status changes to true.

