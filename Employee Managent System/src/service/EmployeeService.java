package service;

import model.Employee;
import repository.EmployeeRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeRepository repository;
    private List<Employee> employees;

    public EmployeeService() {
        this.repository = new EmployeeRepository();
        this.employees = repository.loadEmployees();
    }

    public void addEmployee(int id, String name, String department, double salary, LocalDate joiningDate) {
        employees.add(new Employee(id, name, department, salary, joiningDate));
        repository.saveEmployees(employees);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Optional<Employee> findEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    public void updateEmployee(int id, String name, String department, double salary) {
        findEmployeeById(id).ifPresent(emp -> {
            emp.setName(name);
            emp.setDepartment(department);
            emp.setSalary(salary);
            repository.saveEmployees(employees);
        });
    }

    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
        repository.saveEmployees(employees);
    }
}
