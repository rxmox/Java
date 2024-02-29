import java.util.*;

public interface IToDoList {
    void addTask(Task task);
    void completeTask(String id);
    void deleteTask(String id);
    void editTask(String id, String newTitle, boolean isCompleted);
    List<Task> listTasks();
    void undo();
}

