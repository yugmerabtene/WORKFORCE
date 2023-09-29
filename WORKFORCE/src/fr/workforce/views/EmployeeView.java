package fr.workforce.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
    private JTextArea otherInfoArea;
    private JButton addButton;

    public EmployeeView() {
        // Crée la fenêtre principale
        frame = new JFrame("Gestion des Employés");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Utilise une disposition BorderLayout pour organiser les composants
        frame.setLayout(new BorderLayout());

        // Crée un modèle de liste et une liste pour afficher les employés
        listModel = new DefaultListModel<>();
        employeeList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(employeeList);

        // Crée un JPanel pour organiser les composants d'entrée
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Personnalise l'apparence des composants de texte
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 16);
        matriculeField = createStyledTextField(10, inputFont);
        firstNameField = createStyledTextField(10, inputFont);
        lastNameField = createStyledTextField(10, inputFont);
        dayOfBirthField = createStyledTextField(2, inputFont);
        monthOfBirthField = createStyledTextField(2, inputFont);
        yearOfBirthField = createStyledTextField(4, inputFont);
        hireYearField = createStyledTextField(10, inputFont);

        // Crée un JPanel pour les champs de la date de naissance
        JPanel dateOfBirthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dateOfBirthPanel.add(new JLabel("Date de naissance (JJ - MM - AAAA) : "));
        dateOfBirthPanel.add(dayOfBirthField);
        dateOfBirthPanel.add(new JLabel(" - "));
        dateOfBirthPanel.add(monthOfBirthField);
        dateOfBirthPanel.add(new JLabel(" - "));
        dateOfBirthPanel.add(yearOfBirthField);

        // Personnalise l'apparence de la zone de texte pour les autres informations
        otherInfoArea = new JTextArea(4, 20);
        otherInfoArea.setFont(inputFont);
        otherInfoArea.setLineWrap(true);
        otherInfoArea.setWrapStyleWord(true);
        JScrollPane otherInfoScrollPane = new JScrollPane(otherInfoArea);

        // Crée le bouton Ajouter
        addButton = new JButton("Ajouter");
        addButton.setFont(inputFont);

        // Ajoute les composants au panel d'entrée
        inputPanel.add(new JLabel("Matricule :"));
        inputPanel.add(matriculeField);
        inputPanel.add(new JLabel("Prénom :"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Nom :"));
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("Date de naissance :"));
        inputPanel.add(dateOfBirthPanel);
        inputPanel.add(new JLabel("Année d'embauche :"));
        inputPanel.add(hireYearField);
        inputPanel.add(new JLabel("Autres informations :"));
        inputPanel.add(otherInfoScrollPane);
        inputPanel.add(addButton);

        // Ajoute le panel d'entrée et la liste à la fenêtre
        frame.add(listScrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.WEST);

        // Personnalise l'apparence de la fenêtre pour un design moderne et transparent
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        frame.setBackground(new Color(0, 0, 0, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLocationRelativeTo(null);
    }

    // Méthode pour créer un champ de texte personnalisé
    private JTextField createStyledTextField(int columns, Font font) {
        JTextField textField = new JTextField(columns);
        textField.setFont(font);
        textField.setOpaque(false);
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        return textField;
    }

    // Affiche la fenêtre
    public void show() {
        frame.setVisible(true);
    }

    // Reste des méthodes inchangées
    // ...

    // Méthode pour obtenir les valeurs des champs de saisie
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
                    // Gère le cas où les valeurs sont hors de portée
                    return null;
                }
            } catch (NumberFormatException e) {
                // Gère le cas où les valeurs ne sont pas des entiers valides
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
