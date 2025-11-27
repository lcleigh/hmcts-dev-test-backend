package uk.gov.hmcts.reform.dev.controllers;

import org.springframework.web.bind.annotation.*;
// Imports your Task entity class so the controller can use it.
import uk.gov.hmcts.reform.dev.Task;
// Imports your repository so the controller can talk to the database.
import uk.gov.hmcts.reform.dev.repository.TaskRepository;

// Marks this class as a REST controller. It tells Spring:
// 	- return JSON (not HTML)
// 	- All methods will directly return data, not views.
@RestController
@RequestMapping("/tasks")
public class TaskController {
    // A variable that holds a reference to the repository.
    private final TaskRepository taskRepository;
    // Spring calls this constructor automatically.
    // This is constructor injection, Spring injects the repository for you.
    public TaskController(TaskRepository taskRepository) {
        // Stores the injected repository so your controller can use it.
        this.taskRepository = taskRepository;
    }
    // Make the method handle POST /tasks
    @PostMapping
    // defines method createTask
    // @RequestBody tells Spring:   
    // - Take the JSON from the HTTP request
    // - Convert it into a Task object
    // - Pass that into this method
    public Task createTask(@RequestBody Task task) {
        // saves the task into the database
        return taskRepository.save(task);
    }
}