package de.unistuttgart.iste.ese.api.Assignees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssigneeService {

    private final AssigneeRepository assigneeRepository;

    @Autowired
    public AssigneeService(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    // Get all assignees
    public List<Assignee> getAllAssignees() {
        return (List<Assignee>) assigneeRepository.findAll();
    }

    // Get a single assignee by ID
    public Optional<Assignee> getAssigneeById(Long id) {
        return assigneeRepository.findById(id);
    }

    // Create a new assignee
    public Assignee createAssignee(Assignee assignee) {
        return assigneeRepository.save(assignee);
    }

    // Update an existing assignee
    public Optional<Assignee> updateAssignee(Long id, Assignee assignee) {
        return assigneeRepository.findById(id).map(existingAssignee -> {
            assignee.setId(id); // Ensure the ID is set for the update
            return assigneeRepository.save(assignee);
        });
    }

    // Delete an assignee by ID
    public boolean deleteAssignee(Long id) {
        if (assigneeRepository.existsById(id)) {
            assigneeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
