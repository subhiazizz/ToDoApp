// ToDo.java
package de.unistuttgart.iste.ese.api.ToDos;

import de.unistuttgart.iste.ese.api.Assignees.Assignee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title must not be empty")
    private String title;

    private String description;
    private boolean finished;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Assignee> assigneeList = new ArrayList<>();

    private Long createdDate;
    private Long dueDate;
    private Long finishedDate;

    // Constructors
    public ToDo() {
        this.createdDate = System.currentTimeMillis();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isFinished() { return finished; }
    public void setFinished(boolean finished) { 
        this.finished = finished;
        if (finished) {
            this.finishedDate = System.currentTimeMillis();
        }
    }
    public List<Assignee> getAssigneeList() { return assigneeList; }
    public void setAssigneeList(List<Assignee> assigneeList) { this.assigneeList = assigneeList; }
    public Long getCreatedDate() { return createdDate; }
    public void setCreatedDate(Long createdDate) { this.createdDate = createdDate; }
    public Long getDueDate() { return dueDate; }
    public void setDueDate(Long dueDate) { this.dueDate = dueDate; }
    public Long getFinishedDate() { return finishedDate; }
    public void setFinishedDate(Long finishedDate) { this.finishedDate = finishedDate; }
}