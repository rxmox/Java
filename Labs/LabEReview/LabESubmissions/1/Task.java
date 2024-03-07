//package edu.ucalgary.oop;

import java.util.Objects;

public class Task implements Cloneable {
    private String id;
    private String title;
    private String description;
    private boolean isCompleted = false;

    public Task() {}

    public Task(String id, String title){
        this.id = id;
        this.title = title;
    }

    public Task(String id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void completeTask(boolean complete) {
        isCompleted = complete;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public String getTitle() {
        return this.title;
    }

    public String getIDString() {
        return this.id;
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

    @Override
    public Task clone() {
        try {
            Task clone = (Task) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

