// �tape 5: Cr�ation du contr�leur Employee
package fr.workforce.controllers;

import fr.workforce.models.Employee;
import fr.workforce.services.EmployeeService;
import fr.workforce.views.EmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeController {
    private EmployeeView view;
    private EmployeeService service;

    public EmployeeController(EmployeeView view, EmployeeService service) {
        this.view = view;
        this.service = service;

        // Ajout d'un ActionListener pour le bouton "Ajouter"
        view.addAddButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // R�cup�rer les donn�es du formulaire
                String matricule = view.getMatricule();
                // V�rifier si matricule est nul ou vide
                if (matricule != null && !matricule.isEmpty()) {
                    String firstName = view.getFirstName();
                    String lastName = view.getLastName();
                    String dateOfBirth = view.getDateOfBirth();
                    int hireYear = view.getHireYear();
                    String otherInfo = view.getOtherInfo();

                    // Valider les donn�es et ajouter l'employ�
                    Employee newEmployee = new Employee(0, matricule, firstName, lastName, dateOfBirth, hireYear, otherInfo);
                    service.createEmployee(newEmployee);
                    view.setEmployeeList(service.getAllEmployees());
                    view.clearInputFields();
                } else {
                    // G�rer le cas o� matricule est nul ou vide
                    // Vous pouvez afficher un message d'erreur ou prendre d'autres mesures ici.
                }
            }
        });
    }

    public void start() {
        view.show();
    }
}
