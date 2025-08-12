package util;

public class InputValidator {
    public static boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z\\s]+");
    }

    public static boolean isValidDepartment(String dept) {
        return dept != null && dept.matches("[a-zA-Z\\s]+");
    }

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }
}
