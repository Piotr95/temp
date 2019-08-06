package szczepaniak.projects.todoappbackendspring.repository;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import szczepaniak.projects.todoappbackendspring.domain.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    public void deleteById(Long Id);
}

