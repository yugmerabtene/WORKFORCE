package fr.workforce.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

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
    private JTextArea otherInfoArea; // Utilisation de JTextArea pour les autres informations
    private JButton addButton;

    public EmployeeView() {
        // Cr�e la fen�tre principale
        frame = new JFrame("Gestion des Employ�s");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // D�finit la taille de la fen�tre

        // Cr�e un mod�le de liste et une liste pour afficher les employ�s
        listModel = new DefaultListModel<>();
        employeeList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(employeeList);

        // Cr�e les champs de texte et le bouton Ajouter
        matriculeField = new JTextField(10);
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        dayOfBirthField = new JTextField(2);
        monthOfBirthField = new JTextField(2);
        yearOfBirthField = new JTextField(4);
        hireYearField = new JTextField(10);
        otherInfoArea = new JTextArea(4, 20); // Utilisation de JTextArea pour les autres informations
        addButton = new JButton("Ajouter");

        // Cr�e un JPanel pour les champs de la date de naissance avec un titre
        JPanel dateOfBirthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dateOfBirthPanel.add(new JLabel("Date de naissance (JJ - MM - AAAA) : "));
        dateOfBirthPanel.add(dayOfBirthField);
        dateOfBirthPanel.add(new JLabel(" - "));
        dateOfBirthPanel.add(monthOfBirthField);
        dateOfBirthPanel.add(new JLabel(" - "));
        dateOfBirthPanel.add(yearOfBirthField);

        // Cr�e un JPanel pour organiser les composants d'entr�e
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); // Utilisation de BoxLayout pour aligner les champs de haut en bas
        inputPanel.add(new JLabel("Matricule :"));
        inputPanel.add(matriculeField);
        inputPanel.add(new JLabel("Pr�nom :"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Nom :"));
        inputPanel.add(lastNameField);
        inputPanel.add(dateOfBirthPanel); // Ajoute le JPanel de la date de naissance
        inputPanel.add(new JLabel("Ann�e d'embauche :"));
        inputPanel.add(hireYearField);
        inputPanel.add(new JLabel("Autres informations :"));
        inputPanel.add(new JScrollPane(otherInfoArea)); // Utilisation de JScrollPane pour les autres informations
        inputPanel.add(addButton);

        // Configure la mise en page de la fen�tre
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.WEST); // D�place le panel d'entr�e � gauche

        // Ajoute un style Windows 10
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Affiche la fen�tre
    public void show() {
        frame.setVisible(true);
    }

    // Reste des m�thodes inchang�es
    // ...

    // M�thode pour obtenir les valeurs des champs de saisie
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

        // Valide que les champs sont remplis
        if (!day.isEmpty() && !month.isEmpty() && !year.isEmpty()) {
            // Valide que les valeurs sont des entiers
            try {
                int dayInt = Integer.parseInt(day);
                int monthInt = Integer.parseInt(month);
                int yearInt = Integer.parseInt(year);

                // Valide que les valeurs sont dans des plages raisonnables
                if (yearInt >= 1900 && yearInt <= 2100 &&
                        monthInt >= 1 && monthInt <= 12 &&
                        dayInt >= 1 && dayInt <= 31) {

                    // Formate la date au format AAAA-MM-JJ
                    String formattedDate = String.format("%04d-%02d-%02d", yearInt, monthInt, dayInt);
                    return formattedDate;
                } else {
                    // G�re le cas o� les valeurs sont hors de port�e
                    return null;
                }
            } catch (NumberFormatException e) {
                // G�re le cas o� les valeurs ne sont pas des entiers valides
                return null;
            }
        } else {
            return null; // Retourne null si un champ est vide
        }
    }

    public int getHireYear() {
        try {
            return Integer.parseInt(hireYearField.getText());
        } catch (NumberFormatException e) {
            return 0; // Retourne 0 si la valeur n'est pas un entier valide
        }
    }

    public String getOtherInfo() {
        return otherInfoArea.getText();
    }

    public void clearInputFields() {
        matriculeField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        dayOfBirthField.setText("");
        monthOfBirthField.setText("");
        yearOfBirthField.setText("");
        hireYearField.setText("");
        otherInfoArea.setText("");
    }

    public void setEmployeeList(List<Employee> employees) {
        listModel.clear();
        employees.forEach(listModel::addElement);
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
