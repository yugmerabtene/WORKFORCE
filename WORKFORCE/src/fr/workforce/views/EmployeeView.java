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
    private JTextField dateOfBirthField;
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
        dateOfBirthField = new JTextField(10);
        hireYearField = new JTextField(10);
        otherInfoField = new JTextField(10);
        addButton = new JButton("Ajouter");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));
        inputPanel.add(new JLabel("Matricule:"));
        inputPanel.add(matriculeField);
        inputPanel.add(new JLabel("Prénom:"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Nom:"));
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("Date de naissance:"));
        inputPanel.add(dateOfBirthField);
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

    public void clearInputFields() {
        matriculeField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        dateOfBirthField.setText("");
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
        return dateOfBirthField.getText();
    }

    public int getHireYear() {
        try {
            return Integer.parseInt(hireYearField.getText());
        } catch (NumberFormatException e) {
            return 0; // Retourne 0 en cas d'erreur de conversion
        }
    }

    public String getOtherInfo() {
        return otherInfoField.getText();
    }
}
