import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> todos;
    private String filename;

    public ToDoList(String filename) {
        this.filename = filename;
        todos = new ArrayList<>();
        load();
    }

    public void add(String todo) {
        todos.add(todo);
        save();
    }

    public void remove(int index) {
        todos.remove(index);
        save();
    }

    public void mark(int index) {
        String todo = todos.get(index);
        todos.set(index, "*" + todo);
        save();
    }

    public void unmark(int index) {
        String todo = todos.get(index);
        todos.set(index, todo.substring(1));
        save();
    }

    public void list() {
        for (int i = 0; i < todos.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, todos.get(i));
        }
    }

    private void load() {
        try {
            Scanner scanner = new Scanner(new File("todos.txt"));
            while (scanner.hasNextLine()) {
                todos.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei.");
        }
    }

    private void save() {
        try {
            FileWriter writer = new FileWriter(new File("todos.txt"));
            for (String todo : todos) {
                writer.write(todo + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben in die Datei.");
        }
    }
}
