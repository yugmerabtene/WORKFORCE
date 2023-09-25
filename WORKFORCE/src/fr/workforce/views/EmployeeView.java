package fr.workforce.views;

package fr.workforce.views;

import fr.workforce.models.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmployeeView {
    private JFrame frame;
    private JList<Employee> employeeList;
    private DefaultListModel<Employee> listModel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton addButton;

    public EmployeeView() {
        frame = new JFrame("Gestion des Employés");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        listModel = new DefaultListModel<>();
        employeeList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(employeeList);

        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        addButton = new JButton("Ajouter");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Prénom:"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Nom:"));
        inputPanel.add(lastNameField);
        inputPanel.add(addButton);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public void clearInputFields() {
        firstNameField.setText("");
        lastNameField.setText("");
    }

    public void setEmployeeList(List<Employee> employees) {
        listModel.clear();
        employees.forEach(listModel::addElement);
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
