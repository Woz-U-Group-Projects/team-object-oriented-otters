import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Task } from "./models/task";
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class TaskService {
  // Java Spring Boot uses port 8080
  apiUrl: string = "http://localhost:8080/tasks";

  // C# dotnetcore uses port 5000
  //apiUrl: string = "http://localhost:5000/api/tasks";

  // Express will use port 3000
  //apiUrl: string = "http://localhost:3001/tasks";

  constructor(private http: HttpClient) {}

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.apiUrl);
  }

  addTask(task): Observable<Task> {
    task = {"id":"my it","name":"task name","complete":false};
    //Observable <Task> ob = task;
    //return this.http.post<Task>(this.apiUrl, task);
    let obTask = of(task);
    console.log("Task "+task.name);
    return obTask;
  }
}
