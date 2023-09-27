package fr.workforce.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.workforce.models.Employee;
import fr.workforce.services.EmployeeService;
import fr.workforce.views.EmployeeView;

public class EmployeeController {
    private EmployeeView view;
    private EmployeeService service;

    public EmployeeController(EmployeeView view, EmployeeService service) {
        
    	this.view = view;
        this.service = service;

        view.addAddButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricule = view.getMatricule();
                if (matricule != null && !matricule.isEmpty()) {
                    String firstName = view.getFirstName();
                    String lastName = view.getLastName();
                    String dateOfBirth = view.getDateOfBirth();
                    int hireYear = view.getHireYear();
                    String otherInfo = view.getOtherInfo();

                    Employee newEmployee = new Employee(0, matricule, firstName, lastName, dateOfBirth, hireYear, otherInfo);
                    service.createEmployee(newEmployee);
                    view.setEmployeeList(service.getAllEmployees());
                    view.clearInputFields();
                } else {
                    // Gérer le cas où matricule est nul ou vide
                }
            }
        });
    }

    public void start() {
        view.show();
    }
}
