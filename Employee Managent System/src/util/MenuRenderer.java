package util;

public class MenuRenderer {
    public static void printMainMenu() {
        System.out.println(ConsoleColors.CYAN + "\n===== Employee Management System =====" + ConsoleColors.RESET);
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }
}
