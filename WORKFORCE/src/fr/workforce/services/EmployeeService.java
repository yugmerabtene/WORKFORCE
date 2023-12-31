package fr.workforce.services;

import java.util.List;

import fr.workforce.models.Employee;

public interface EmployeeService {

    void createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    void updateEmployee(Employee updatedEmployee);

    void deleteEmployee(int id);

}
