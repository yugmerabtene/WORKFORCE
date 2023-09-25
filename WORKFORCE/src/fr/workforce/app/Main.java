package fr.workforce.app;

import fr.workforce.controllers.EmployeeController;
import fr.workforce.models.Employee;
import fr.workforce.services.EmployeeService;

public class Main {

    public static void main(String[] args) {
        // Initialisez vos services et contr�leurs ici
        EmployeeService employeeService = new EmployeeService();
        EmployeeController employeeController = new EmployeeController(employeeService);

        // Utilisez les m�thodes du contr�leur pour g�rer les employ�s
        employeeController.listEmployees();

        // Cr�ez un nouvel employ�
        Employee newEmployee = new Employee(3, "Alice", "Johnson");
        employeeController.createEmployee(newEmployee);
    }
}

