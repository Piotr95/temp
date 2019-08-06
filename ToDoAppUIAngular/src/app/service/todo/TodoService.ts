import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ToDo } from '../../model/ToDo';
@Injectable({
  providedIn: 'root'
})
export class TodoService {


  private  todosUrl: string = 'api/todos/';
  private  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  constructor(private http: HttpClient) { }


  public getTodos(): Observable<ToDo[]> {
    return this.http.get<ToDo[]>(this.todosUrl);
  }
    // Delete Todo
  public deleteTodo(id: number) {
    return this.http.delete(this.todosUrl + id);
  }

  // Add Todo
  addTodo(todo: ToDo): Observable<ToDo> {
    return this.http.post<ToDo>(this.todosUrl, todo, this.httpOptions);
  }

  // Toggle Completed
  toggleCompleted(todo: ToDo): Observable <any> {
    return this.http.put(`${this.todosUrl}${todo.id}`, todo, this.httpOptions);
  }
}

