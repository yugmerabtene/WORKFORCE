package fr.workforce.services;

import java.util.List;

import fr.workforce.models.Employee;
import fr.workforce.repositories.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createEmployee(Employee employee) {
        repository.createEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return repository.getEmployeeById(id);
    }

    @Override
    public void updateEmployee(Employee updatedEmployee) {
        repository.updateEmployee(updatedEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteEmployee(id);
    }
}
