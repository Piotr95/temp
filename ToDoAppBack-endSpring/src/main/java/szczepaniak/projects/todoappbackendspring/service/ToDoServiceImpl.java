package szczepaniak.projects.todoappbackendspring.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szczepaniak.projects.todoappbackendspring.domain.model.ToDo;
import szczepaniak.projects.todoappbackendspring.infrastructure.config.swagger.exeption.ResourceNotFoundException;
import szczepaniak.projects.todoappbackendspring.repository.ToDoRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ToDoServiceImpl {

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    private ToDoRepository toDoRepository;

    public ToDo create(ToDo toDo){
    return toDoRepository.save(toDo);
}

    public void delete(Long Id){
    toDoRepository.deleteById(Id);
    }
    public ToDo getToDo(Long Id) {
        return toDoRepository.findById(Id).orElseThrow(ResourceNotFoundException::new);
    }
    public List<ToDo> getAll( )  {
        return toDoRepository.findAll().stream().collect(Collectors.toList());
    }



    public ToDo update(Long id, String title, Boolean completed) {
        ToDo toDo=getToDo(id);
        toDo.setTitle(title);
        toDo.setCompleted(completed);
        return toDo;
    }
}
