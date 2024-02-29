import java.util.*;

public class ToDoList implements IToDoList {
    private List<Task> tasks; // List to manage tasks
    private Stack<List<Task>> history; // Stack to track the history of operations

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.history = new Stack<>();
    }

    private void saveState() {
        // Create a deep copy of the current list of tasks for the history
        List<Task> copyOfCurrentState = new ArrayList<>();
        for (Task task : tasks) {
            try {
                copyOfCurrentState.add((Task) task.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        history.push(copyOfCurrentState);
    }

    @Override
    public void addTask(Task task) {
        saveState();
        tasks.add(task);
    }

    @Override
    public void completeTask(String id) {
        saveState();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setCompleted(true);
                break;
            }
        }
    }

    @Override
    public void deleteTask(String id) {
        saveState();
        tasks.removeIf(task -> task.getId().equals(id));
    }

    @Override
    public void editTask(String id, String newTitle, boolean isCompleted) {
        saveState();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setTitle(newTitle);
                //task.setDescription(newDescription);
                task.setCompleted(isCompleted);
                break;
            }
        }
    }

    @Override
    public List<Task> listTasks() {
        return tasks;
    }

    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = history.pop();
        }
    }
}
