package repository;

import model.Employee;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private final File dataFile;

    public EmployeeRepository() {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir(); // auto-create data folder
        }
        dataFile = new File(dataDir, "employees.dat");
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile(); // auto-create data file
                saveEmployees(new ArrayList<>());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Employee> loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile))) {
            return (List<Employee>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<>(); // empty file
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
