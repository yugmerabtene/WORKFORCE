package fr.workforce.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.workforce.controllers.EmployeeController;
import fr.workforce.database.EmployeeDatabase;
import fr.workforce.repositories.EmployeeRepository;
import fr.workforce.repositories.EmployeeRepositoryImpl;
import fr.workforce.services.EmployeeService;
import fr.workforce.services.EmployeeServiceImpl;
import fr.workforce.views.EmployeeView;

public class Main {
    public static void main(String[] args) {
        // Cr�ez la base de donn�es si elle n'existe pas
        EmployeeDatabase.checkDatabase();

        // �tablissez une connexion � la base de donn�es
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/workforce", "root", "");

            // Cr�ez l'instance du repository et du service
            EmployeeRepository repository = new EmployeeRepositoryImpl(connection);
            EmployeeService service = new EmployeeServiceImpl(repository);

            // Cr�ez la vue et le contr�leur
            EmployeeView view = new EmployeeView();
            EmployeeController controller = new EmployeeController(view, service);

            // Affichez la vue principale de l'application
            view.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
