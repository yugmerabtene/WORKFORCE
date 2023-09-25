package fr.workforce.services;

import fr.workforce.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        // Initialisez la liste des employ�s (simulons des donn�es fictives)
        employees = new ArrayList<>();
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Jane", "Smith"));
    }

    // M�thode pour r�cup�rer tous les employ�s
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // M�thode pour cr�er un nouvel employ�
    public void createEmployee(Employee newEmployee) {
        employees.add(newEmployee);
    }

    // Ajoutez d'autres m�thodes pour la logique m�tier li�e aux employ�s
}

