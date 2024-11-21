package de.unistuttgart.iste.ese.api.ToDos;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class ToDoDTO {
    @NotBlank(message = "Title must not be empty")
    private String title;
    private String description;
    private boolean finished;
    private List<Long> assigneeIdList;
    private Long dueDate;

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isFinished() { return finished; }
    public void setFinished(boolean finished) { this.finished = finished; }
    public List<Long> getAssigneeIdList() { return assigneeIdList; }
    public void setAssigneeIdList(List<Long> assigneeIdList) { this.assigneeIdList = assigneeIdList; }
    public Long getDueDate() { return dueDate; }
    public void setDueDate(Long dueDate) { this.dueDate = dueDate; }
}