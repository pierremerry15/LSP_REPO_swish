package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects using a Map for efficient retrieval.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a task to the manager. 
     * @param task The task to add
     * @throws IllegalArgumentException if the task ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            throw new IllegalArgumentException("Duplicate Task ID: " + task.getId());
        }
        tasks.put(task.getId(), task);
    }

    /**
     * Finds a specific task by its ID.
     * @param id The ID to search for
     * @return The Task object, or null if not found
     */
    public Task findTask(String id) {
        return tasks.get(id);
    }

    /**
     * Retrieves all tasks matching a specific status.
     * @param status The status to filter by
     * @return A list of matching Task objects
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
}