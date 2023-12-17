import org.junit.*;

public class TaskTest {

    @Test
    public void createValidTask() {
        Task task = new Task("1", "Task 1", "Description 1");
        Assert.assertEquals("1", task.getTaskId());
        Assert.assertEquals("Task 1", task.getName());
        Assert.assertEquals("Description 1", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTaskWithInvalidId() {
        // Attempt to create a task with an invalid ID
        new Task("Invalid Task ID", "Task 2", "Description 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTaskWithInvalidName() {
        // Attempt to create a task with an invalid name
        new Task("2", "Very Long Task Name That Exceeds the Limit", "Description 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTaskWithInvalidDescription() {
        // Attempt to create a task with an invalid description
        new Task("3", "Task 3", "Very Long Task Description That Exceeds the Limit");
    }

    @Test
    public void updateTaskName() {
        // Create a task
        Task task = new Task("4", "Task 4", "Description 4");

        // Update the task name
        task.setName("Updated Task Name");
        Assert.assertEquals("Updated Task Name", task.getName());
    }

    @Test
    public void updateTaskDescription() {
        // Create a task
        Task task = new Task("5", "Task 5", "Description 5");

        // Update the task description
        task.setDescription("Updated Task Description");
        Assert.assertEquals("Updated Task Description", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateTaskWithInvalidName() {
        // Create a task
        Task task = new Task("6", "Task 6", "Description 6");

        // Attempt to update the task name with an invalid value
        task.setName("Very Long Updated Task Name That Exceeds the Limit");
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateTaskWithInvalidDescription() {
        // Create a task
        Task task = new Task("7", "Task 7", "Description 7");

        // Attempt to update the task description with an invalid value
        task.setDescription("Very Long Updated Task Description That Exceeds the Limit");
    }

    // Add more test cases as needed
}
