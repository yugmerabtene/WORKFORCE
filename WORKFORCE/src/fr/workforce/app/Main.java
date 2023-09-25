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
        // Créez la base de données si elle n'existe pas
        EmployeeDatabase.checkDatabase();

        // Établissez une connexion à la base de données
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/workforce", "root", "");

            // Créez l'instance du repository et du service
            EmployeeRepository repository = new EmployeeRepositoryImpl(connection);
            EmployeeService service = new EmployeeServiceImpl(repository);

            // Créez la vue et le contrôleur
            EmployeeView view = new EmployeeView();
            EmployeeController controller = new EmployeeController(view, service);

            // Affichez la vue principale de l'application
            view.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
