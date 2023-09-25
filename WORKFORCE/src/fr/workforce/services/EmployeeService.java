package fr.workforce.services;

import fr.workforce.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        // Initialisez la liste des employés (simulons des données fictives)
        employees = new ArrayList<>();
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Jane", "Smith"));
    }

    // Méthode pour récupérer tous les employés
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Méthode pour créer un nouvel employé
    public void createEmployee(Employee newEmployee) {
        employees.add(newEmployee);
    }

    // Ajoutez d'autres méthodes pour la logique métier liée aux employés
}

