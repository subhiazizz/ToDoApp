package de.unistuttgart.iste.ese.api.Assignees;

import de.unistuttgart.iste.ese.api.ApiVersion1;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@ApiVersion1
public class AssigneeController {

    @Autowired
    private AssigneeRepository assigneeRepository;

    // Initialize the database with sample data if empty
    @PostConstruct
    public void init() {
        if (assigneeRepository.count() == 0) {
            assigneeRepository.save(new Assignee("John", "Doe", "john.doe@uni-stuttgart.de"));
            assigneeRepository.save(new Assignee("Jane", "Doe", "jane.doe@uni-stuttgart.de"));
        }
    }

    // Get all assignees
    @GetMapping("/assignees")
    public List<Assignee> getAssignees() {
        return (List<Assignee>) assigneeRepository.findAll();
    }

    // Get a single assignee by ID
    @GetMapping("/assignees/{id}")
    public Assignee getAssignee(@PathVariable("id") long id) {
        return assigneeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                        String.format("Assignee with ID %s not found!", id)));
    }

    // Create a new assignee
    @PostMapping("/assignees")
    @ResponseStatus(HttpStatus.CREATED)
    public Assignee createAssignee(@Valid @RequestBody Assignee requestBody) {
        return assigneeRepository.save(new Assignee(requestBody.getPrename(), requestBody.getName(), requestBody.getEmail()));
    }

    // Update an existing assignee
    @PutMapping("/assignees/{id}")
    public Assignee updateAssignee(@PathVariable("id") long id, @Valid @RequestBody Assignee requestBody) {
        return assigneeRepository.findById(id).map(existingAssignee -> {
            existingAssignee.setPrename(requestBody.getPrename());
            existingAssignee.setName(requestBody.getName());
            existingAssignee.setEmail(requestBody.getEmail());
            return assigneeRepository.save(existingAssignee);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                String.format("Assignee with ID %s not found!", id)));
    }

    // Delete an assignee by ID
    @DeleteMapping("/assignees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAssignee(@PathVariable("id") long id) {
        if (!assigneeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
                    String.format("Assignee with ID %s not found!", id));
        }
        assigneeRepository.deleteById(id);
    }
}