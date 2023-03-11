import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList todoList = new ToDoList("todos.txt");
        String input;

        System.out.println("Willkommen bei der ToDo-Liste!");

        do {
            System.out.println("Was möchtest du tun?");
            System.out.println("[1] To-Do hinzufügen");
            System.out.println("[2] To-Do löschen");
            System.out.println("[3] To-Do markieren");
            System.out.println("[4] To-Do entmarkieren");
            System.out.println("[5] To-Dos auflisten");
            System.out.println("[0] Beenden");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Gib das neue To-Do ein:");
                    String newTodo = scanner.nextLine();
                    todoList.add(newTodo);
                    System.out.println("To-Do hinzugefügt: " + newTodo);
                    break;
                case "2":
                    System.out.println("Welches To-Do möchtest du löschen?");
                    int deleteIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    todoList.remove(deleteIndex);
                    System.out.println("To-Do gelöscht.");
                    break;
                case "3":
                    System.out.println("Welches To-Do möchtest du markieren?");
                    int markIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    todoList.mark(markIndex);
                    System.out.println("To-Do markiert.");
                    break;
                case "4":
                    System.out.println("Welches To-Do möchtest du entmarkieren?");
                    int unmarkIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    todoList.unmark(unmarkIndex);
                    System.out.println("To-Do entmarkiert.");
                    break;
                case "5":
                    System.out.println("To-Dos:");
                    todoList.list();
                    break;
                case "0":
                    System.out.println("Auf Wiedersehen!");
                    break;
                default:
                    System.out.println("Ungültige Eingabe, bitte versuche es erneut.");
                    break;
            }

        } while (!input.equals("0"));

        scanner.close();
    }

}
