//package edu.ucalgary.oop;

import java.util.*;

public class Task implements Cloneable {
    private String id;
    private String title;
    //private String description;
    private boolean isCompleted;

    // Constructor
    public Task(String id, String title) {
        this.id = id;
        this.title = title;
        //this.description = description;
        this.isCompleted = false; // Tasks are not completed by default
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // public String getDescription() {
    //     return description;
    // }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // public void setDescription(String description) {
    //     this.description = description;
    // }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Overriding the clone() method for deep copying task objects
    @Override
    public Object clone() throws CloneNotSupportedException {
        Task cloned = (Task) super.clone();
        return cloned;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id) &&
               Objects.equals(title, task.title) &&
               isCompleted == task.isCompleted; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }
}
