package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private Map<Long, Task> taskRepository = new HashMap<>();
    private Long currentId = 1L;

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskRepository.values());
    }

    public Task getTaskById(Long id) {
        return taskRepository.get(id);
    }

    public Task createTask(Task task) {
        task.setId(currentId++);
        task.setCreateDate(new Date());
        taskRepository.put(task.getId(), task);
        return task;
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.get(id);
        if (existingTask != null) {
            task.setId(id);
            task.setCreateDate(existingTask.getCreateDate());
            if (task.getCompleted() && existingTask.getCompletedDate() == null) {
                task.setCompletedDate(new Date());
            } else {
                task.setCompletedDate(existingTask.getCompletedDate());
            }
            taskRepository.put(id, task);
            return task;
        }
        return null;
    }
}
