package fr.workforce.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import fr.workforce.models.Employee;
import fr.workforce.views.EmployeeView;

public class EmployeeController {
    private EmployeeView view;
    private List<Employee> employees;

    public EmployeeController(EmployeeView view) {
        this.view = view;
        employees = new ArrayList<>();

        // Ajoutez des employés de test (vous pouvez les charger à partir de la base de données)
        employees.add(new Employee("John", "Doe"));
        employees.add(new Employee("Jane", "Smith"));

        view.setEmployeeList(employees);

        view.addAddButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = view.getFirstName();
                String lastName = view.getLastName();
                if (!firstName.isEmpty() && !lastName.isEmpty()) {
                    Employee newEmployee = new Employee(firstName, lastName);
                    employees.add(newEmployee);
                    view.setEmployeeList(employees);
                    view.clearInputFields();
                }
            }
        });
    }

    public void start() {
        view.show();
    }

    public static void main(String[] args) {
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(view);
        controller.start();
    }
}


