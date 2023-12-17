public class Task {
    private final String taskId; // Non-updatable
    private String name;
    private String description;

    /**
     * Constructor to create a Task.
     * @param taskId The task ID.
     * @param name The task name.
     * @param description The task description.
     * @throws IllegalArgumentException if any parameter is invalid.
     */
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) throw new IllegalArgumentException("Invalid Task ID");
        if (name == null || name.length() > 20) throw new IllegalArgumentException("Invalid Name");
        if (description == null || description.length() > 50) throw new IllegalArgumentException("Invalid Description");

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the task ID.
     * @return The task ID.
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Gets the task name.
     * @return The task name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the task name.
     * @param name The new task name.
     * @throws IllegalArgumentException if the name is invalid.
     */
    public void setName(String name) {
        if (name == null || name.length() > 20) throw new IllegalArgumentException("Invalid Name");
        this.name = name;
    }

    /**
     * Gets the task description.
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the task description.
     * @param description The new task description.
     * @throws IllegalArgumentException if the description is invalid.
     */
    public void setDescription(String description) {
        if (description == null || description.length() > 50) throw new IllegalArgumentException("Invalid Description");
        this.description = description;
    }
}
