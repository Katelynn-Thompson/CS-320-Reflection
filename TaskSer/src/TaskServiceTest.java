import java.util.NoSuchElementException;

import org.junit.*;

public class TaskServiceTest {
    private TaskService taskService;

    @Before
    public void setup() {
        taskService = new TaskService();
    }

    @Test
    public void addValidTask() {
        taskService.addTask("1", "Task 1", "Description 1");
        // You can add assertions here to check if the task was added successfully
        Assert.assertEquals("Task 1", taskService.getAllTasks().get("1").getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTaskWithDuplicateId() {
        // Add a task with a valid ID
        taskService.addTask("1", "Task 1", "Description 1");
        // Attempt to add another task with the same ID
        taskService.addTask("1", "Task 2", "Description 2");
    }

    @Test
    public void deleteTask() {
        // Add a task
        taskService.addTask("2", "Task 2", "Description 2");
        // Delete the task
        taskService.deleteTask("2");
        // Ensure the task is no longer present
        Assert.assertNull(taskService.getAllTasks().get("2"));
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteNonexistentTask() {
        // Attempt to delete a task that does not exist
        taskService.deleteTask("3");
    }

    @Test
    public void updateTask() {
        // Add a task
        taskService.addTask("4", "Task 4", "Description 4");
        // Update the task
        taskService.updateTask("4", "Updated Task Name", "Updated Description");
        // Ensure the task has been updated
        Task updatedTask = taskService.getAllTasks().get("4");
        Assert.assertEquals("Updated Task Name", updatedTask.getName());
        Assert.assertEquals("Updated Description", updatedTask.getDescription());
    }

    @Test(expected = NoSuchElementException.class)
    public void updateNonexistentTask() {
        // Attempt to update a task that does not exist
        taskService.updateTask("5", "Updated Task Name", "Updated Description");
    }

    // Add more test cases as needed
}

