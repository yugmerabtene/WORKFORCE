package fr.workforce.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import fr.workforce.models.Employee;

public class EmployeeView {
    private JFrame frame;
    private JList<Employee> employeeList;
    private DefaultListModel<Employee> listModel;
    private JTextField matriculeField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dayOfBirthField;
    private JTextField monthOfBirthField;
    private JTextField yearOfBirthField;
    private JTextField hireYearField;
    private JTextField otherInfoField;
    private JButton addButton;

    public EmployeeView() {
        frame = new JFrame("Gestion des Employés");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        listModel = new DefaultListModel<>();
        employeeList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(employeeList);

        matriculeField = new JTextField(10);
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        dayOfBirthField = new JTextField(2); // Champ pour le jour
        monthOfBirthField = new JTextField(2); // Champ pour le mois
        yearOfBirthField = new JTextField(4); // Champ pour l'année
        hireYearField = new JTextField(10);
        otherInfoField = new JTextField(10);
        addButton = new JButton("Ajouter");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(8, 2));
        inputPanel.add(new JLabel("Matricule:"));
        inputPanel.add(matriculeField);
        inputPanel.add(new JLabel("Prénom:"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Nom:"));
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("Date de naissance (JJ-MM-AAAA):"));
        inputPanel.add(dayOfBirthField);
        inputPanel.add(monthOfBirthField);
        inputPanel.add(yearOfBirthField);
        inputPanel.add(new JLabel("Année d'embauche:"));
        inputPanel.add(hireYearField);
        inputPanel.add(new JLabel("Autres informations:"));
        inputPanel.add(otherInfoField);
        inputPanel.add(addButton);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    // Méthodes pour obtenir les valeurs des champs de saisie
    public String getMatricule() {
        return matriculeField.getText();
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getDateOfBirth() {
        String day = dayOfBirthField.getText();
        String month = monthOfBirthField.getText();
        String year = yearOfBirthField.getText();

        // Valider que les champs sont remplis
        if (!day.isEmpty() && !month.isEmpty() && !year.isEmpty()) {
            // Valider que les valeurs sont des entiers
            try {
                int dayInt = Integer.parseInt(day);
                int monthInt = Integer.parseInt(month);
                int yearInt = Integer.parseInt(year);

                // Valider que les valeurs sont dans des plages raisonnables
                if (yearInt >= 1900 && yearInt <= 2100 &&
                    monthInt >= 1 && monthInt <= 12 &&
                    dayInt >= 1 && dayInt <= 31) {

                    // Formater la date au format AAAA-MM-JJ
                    String formattedDate = String.format("%04d-%02d-%02d", yearInt, monthInt, dayInt);
                    return formattedDate;
                } else {
                    // Gérer le cas où les valeurs sont hors de portée
                    return null;
                }
            } catch (NumberFormatException e) {
                // Gérer le cas où les valeurs ne sont pas des entiers valides
                return null;
            }
        } else {
            return null; // Retourner null si un champ est vide
        }
    }

    public int getHireYear() {
        try {
            return Integer.parseInt(hireYearField.getText());
        } catch (NumberFormatException e) {
            return 0; // Retourner 0 si la valeur n'est pas un entier valide
        }
    }

    public String getOtherInfo() {
        return otherInfoField.getText();
    }

    public void clearInputFields() {
        matriculeField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        dayOfBirthField.setText("");
        monthOfBirthField.setText("");
        yearOfBirthField.setText("");
        hireYearField.setText("");
        otherInfoField.setText("");
    }

    public void setEmployeeList(List<Employee> employees) {
        listModel.clear();
        employees.forEach(listModel::addElement);
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
