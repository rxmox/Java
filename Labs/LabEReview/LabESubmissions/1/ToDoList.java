//package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList{
    private List<Task> myTasks = new ArrayList<>();
    private Stack<List<Task>> myStack = new Stack<List<Task>>();
    
    public ToDoList() { 

    }

    public void undo() {
        System.err.println(myStack);
        myTasks = myStack.pop();
        System.err.println(myTasks);
    }

    @Override
    public void addTask(Task taskArg) {
        // Save previous state
        List<Task> copyTask = new ArrayList<>(); 
        copyTask.addAll(myTasks); 
        myStack.push(copyTask);

        // Add new state
        myTasks.add(taskArg);
        System.err.println(myStack);
    }

    @Override
    public List<Task> listTasks() {
       return(myTasks);
    }

    @Override
    public void completeTask(String id) {
        myTasks.get(Integer.valueOf(id) - 1).completeTask(true);
    }

    @Override
    public void deleteTask(String id) {
        // Save previous state
        List<Task> copyTask = new ArrayList<>(); 
        copyTask.addAll(myTasks); 
        myStack.push(copyTask);

        // Delete last state
        myTasks.remove(Integer.valueOf(id) - 1);
    }

    @Override
    public void editTask(String id, String title, boolean complete) {
        // Save previous state
        myStack.push(myTasks);

        // Edit current state
        myTasks.get(Integer.valueOf(id) - 1).updateTitle(title);

        myTasks.get(Integer.valueOf(id) - 1).completeTask(complete);
    }
}
