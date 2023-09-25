package fr.workforce.app;

import fr.workforce.controllers.EmployeeController;
import fr.workforce.models.Employee;
import fr.workforce.services.EmployeeService;

public class Main {

    public static void main(String[] args) {
        // Initialisez vos services et contrôleurs ici
        EmployeeService employeeService = new EmployeeService();
        EmployeeController employeeController = new EmployeeController(employeeService);

        // Utilisez les méthodes du contrôleur pour gérer les employés
        employeeController.listEmployees();

        // Créez un nouvel employé
        Employee newEmployee = new Employee(3, "Alice", "Johnson");
        employeeController.createEmployee(newEmployee);
    }
}

