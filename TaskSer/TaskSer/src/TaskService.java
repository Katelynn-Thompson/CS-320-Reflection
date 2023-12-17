import java.util.*;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(String taskId, String name, String description) {
        validateTaskParams(taskId, name, description);

        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID already exists");
        }

        tasks.put(taskId, new Task(taskId, name, description));
    }

    public void deleteTask(String taskId) {
        tasks.remove(taskId);
    }

    public void updateTask(String taskId, String newName, String newDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new NoSuchElementException("Task ID does not exist");
        }

        // Only updates the name and description fields
        if (newName != null && newName.length() <= 20) {
            task.setName(newName);
        }

        if (newDescription != null && newDescription.length() <= 50) {
            task.setDescription(newDescription);
        }
    }

    public Map<String, Task> getAllTasks() {
        return tasks;
    }

    private void validateTaskParams(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid Task ID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
    }
}
