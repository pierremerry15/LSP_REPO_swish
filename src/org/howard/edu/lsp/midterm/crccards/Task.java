package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a single Task in the management system.
 * Handles task data and status validation.
 */
public class Task {
    private String id;
    private String name;
    private String status;

    /**
     * Constructor for Task. Defaults status to "OPEN".
     * @param id The unique identifier for the task
     * @param name The descriptive name of the task
     */
    public Task(String id, String name) {
        this.id = id;
        this.name = name;
        this.status = "OPEN";
    }

    /**
     * Sets the task status. Validates against allowed types.
     * @param status The new status to set
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getStatus() { return status; }

    /**
     * Returns the task in the required format: [ID] Name - Status
     * @return Formatted task string
     */
    @Override
    public String toString() {
        return "[" + id + "] " + name + " - " + status;
    }
}