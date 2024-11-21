package de.unistuttgart.iste.ese.api.ToDos;

import de.unistuttgart.iste.ese.api.ApiVersion1;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@ApiVersion1
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todos")
    public List<ToDo> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @GetMapping("/todos/{id}")
    public ToDo getToDoById(@PathVariable Long id) {
        return toDoService.getToDoById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public ToDo createToDo(@Valid @RequestBody ToDoDTO toDoDTO) {
        return toDoService.createToDo(toDoDTO);
    }

    @PutMapping("/todos/{id}")
    public ToDo updateToDo(@PathVariable Long id, @Valid @RequestBody ToDoDTO toDoDTO) {
        return toDoService.updateToDo(id, toDoDTO)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteToDo(@PathVariable Long id) {
        if (!toDoService.deleteToDo(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
