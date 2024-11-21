package de.unistuttgart.iste.ese.api.ToDos;

import de.unistuttgart.iste.ese.api.Assignees.Assignee;
import de.unistuttgart.iste.ese.api.Assignees.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
// import java.util.stream.Collectors;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;
    
    @Autowired
    private AssigneeRepository assigneeRepository;

    public List<ToDo> getAllToDos() {
        return (List<ToDo>) toDoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(Long id) {
        return toDoRepository.findById(id);
    }

    public ToDo createToDo(ToDoDTO toDoDTO) {
        validateToDoDTO(toDoDTO);
        
        ToDo toDo = new ToDo();
        toDo.setTitle(toDoDTO.getTitle());
        toDo.setDescription(toDoDTO.getDescription());
        toDo.setDueDate(toDoDTO.getDueDate());
        
        if (toDoDTO.getAssigneeIdList() != null) {
            List<Assignee> assignees = (List<Assignee>) assigneeRepository.findAllById(toDoDTO.getAssigneeIdList());
            toDo.setAssigneeList(assignees);
        }
        
        return toDoRepository.save(toDo);
    }

    public Optional<ToDo> updateToDo(Long id, ToDoDTO toDoDTO) {
        validateToDoDTO(toDoDTO);
        
        return toDoRepository.findById(id).map(toDo -> {
            toDo.setTitle(toDoDTO.getTitle());
            toDo.setDescription(toDoDTO.getDescription());
            toDo.setFinished(toDoDTO.isFinished());
            toDo.setDueDate(toDoDTO.getDueDate());
            
            if (toDoDTO.getAssigneeIdList() != null) {
                List<Assignee> assignees = (List<Assignee>) assigneeRepository.findAllById(toDoDTO.getAssigneeIdList());
                toDo.setAssigneeList(assignees);
            }
            
            return toDoRepository.save(toDo);
        });
    }

    public boolean deleteToDo(Long id) {
        if (toDoRepository.existsById(id)) {
            toDoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private void validateToDoDTO(ToDoDTO toDoDTO) {
        if (toDoDTO.getTitle() == null || toDoDTO.getTitle().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title must not be empty");
        }

        if (toDoDTO.getAssigneeIdList() != null) {
            // Check for duplicate assignee IDs
            Set<Long> uniqueIds = new HashSet<>(toDoDTO.getAssigneeIdList());
            if (uniqueIds.size() != toDoDTO.getAssigneeIdList().size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicate assignee IDs are not allowed");
            }

            // Verify all assignees exist
            List<Assignee> foundAssignees = (List<Assignee>) assigneeRepository.findAllById(toDoDTO.getAssigneeIdList());
            if (foundAssignees.size() != toDoDTO.getAssigneeIdList().size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more assignee IDs do not exist");
            }
        }
    }
}