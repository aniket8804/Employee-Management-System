package ui;

import service.EmployeeService;
import util.ConsoleColors;
import util.DateUtils;
import util.InputValidator;
import util.MenuRenderer;
import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeManagementApp {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            MenuRenderer.printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    if (!InputValidator.isValidName(name)) {
                        System.out.println(ConsoleColors.RED + "Invalid name!" + ConsoleColors.RESET);
                        break;
                    }

                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    if (!InputValidator.isValidDepartment(dept)) {
                        System.out.println(ConsoleColors.RED + "Invalid department!" + ConsoleColors.RESET);
                        break;
                    }

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    if (!InputValidator.isValidSalary(salary)) {
                        System.out.println(ConsoleColors.RED + "Invalid salary!" + ConsoleColors.RESET);
                        break;
                    }

                    scanner.nextLine();
                    System.out.print("Enter Joining Date (dd-MM-yyyy): ");
                    String dateStr = scanner.nextLine();
                    LocalDate date = DateUtils.parseDate(dateStr);

                    service.addEmployee(id, name, dept, salary, date);
                    System.out.println(ConsoleColors.GREEN + "Employee added successfully!" + ConsoleColors.RESET);
                    break;

                case 2:
                    service.getAllEmployees().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDept = scanner.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();

                    service.updateEmployee(uid, newName, newDept, newSalary);
                    System.out.println(ConsoleColors.GREEN + "Employee updated successfully!" + ConsoleColors.RESET);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int did = scanner.nextInt();
                    service.deleteEmployee(did);
                    System.out.println(ConsoleColors.RED + "Employee deleted successfully!" + ConsoleColors.RESET);
                    break;

                case 5:
                    System.out.println(ConsoleColors.YELLOW + "Exiting... Goodbye!" + ConsoleColors.RESET);
                    scanner.close();
                    return;

                default:
                    System.out.println(ConsoleColors.RED + "Invalid choice!" + ConsoleColors.RESET);
            }
        }
    }
}
