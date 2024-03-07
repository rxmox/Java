//package edu.ucalgary.oop;

import java.util.List;

public interface IToDoList {
    public void addTask(Task task);

    public List<Task> listTasks();

    public void completeTask(String id);

    public void deleteTask(String id);

    public void editTask(String id, String description, boolean complete);

}