import { Component, OnInit } from '@angular/core';
import { ToDo } from '../../model/ToDo';
import { TodoService } from '../../service/todo/TodoService';

@Component  ({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.sass']
})
export class TodoListComponent implements OnInit {
  todos: ToDo[];
  constructor(private todoService: TodoService) { }


  deleteTodo(todo: ToDo) {
    // Remove From UI
    this.todos = this.todos.filter(t => t.id !== todo.id);
    // Remove from server
    this.todoService.deleteTodo(todo.id).subscribe(); }

    addTodo(todo: ToDo) {
      // tslint:disable-next-line:no-shadowed-variable
      this.todoService.addTodo(todo).subscribe(todo => {
        this.todos.push();
      });
    }


  ngOnInit() {
    this.todoService.getTodos().subscribe(todos => {
      this.todos = todos;
});
  }
}
