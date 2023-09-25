package fr.workforce.repositories;

import fr.workforce.models.Employee;

import java.util.List;

public interface EmployeeRepository {

    void createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    void updateEmployee(Employee updatedEmployee);

    void deleteEmployee(int id);

}
