package szczepaniak.projects.todoappbackendspring.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ToDo {

    public ToDo(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue
    Long id;
    String title;
    Boolean completed=false;
}
