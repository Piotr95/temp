package szczepaniak.projects.todoappbackendspring.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import szczepaniak.projects.todoappbackendspring.domain.model.ToDo;
import szczepaniak.projects.todoappbackendspring.repository.ToDoRepository;
import szczepaniak.projects.todoappbackendspring.service.ToDoServiceImpl;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    private ToDoServiceImpl toDoService;

    public ToDoController(ToDoServiceImpl toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping()
    public List<ToDo> getAll() {
        return toDoService.getAll();
    }

    @GetMapping("/{id}")
    public ToDo getToDo(@PathVariable("id") Long id) {
        return toDoService.getToDo(id);
    }

    @PostMapping
    public ToDo create(@RequestParam String title) {
        return toDoService.create(new ToDo(title));
    }

    @PutMapping("/{id}")
    public ToDo update(@PathVariable(value = "id") Long id, @Valid @RequestParam String title,@Valid @RequestParam Boolean completed) {
        return toDoService.update(id,title,completed);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        toDoService.delete(id);
    }


}
