import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ToDo } from 'src/app/model/ToDo';
import { TodoService } from 'src/app/service/todo/TodoService';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.sass']
})
export class TodoComponent implements OnInit {

  @Output() deleteTodo: EventEmitter<ToDo> = new EventEmitter();
  @Input() todo: ToDo;
  constructor( private todoService: TodoService) { }
  setclasses() {
    const classes = {
      todo: true,
      'is-complete': this.todo.completed
    };

    return classes;
}

onToggle(todo) {
  // Toggle in UI
  todo.completed = !todo.completed;
  // Toggle on server
  this.todoService.toggleCompleted(todo).subscribe(todo => console.log(todo));
}

onDelete(todo) {
  this.deleteTodo.emit(todo);
}
  ngOnInit() {
  }

}
