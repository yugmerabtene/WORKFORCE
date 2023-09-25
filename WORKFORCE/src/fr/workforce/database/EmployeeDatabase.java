// Étape 1: Création de la base de données
package fr.workforce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDatabase {

    // Méthode pour vérifier l'existence de la base de données
    public static void checkDatabase() {
        Connection connection = null;
        Statement statement = null;

        try {
            // Charger le pilote JDBC MySQL (assurez-vous d'ajouter la bibliothèque MySQL JDBC à votre projet)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir une connexion à la base de données MySQL
            String url = "jdbc:mysql://localhost:3306/workforce"; // Remplacez "votre_base_de_donnees" par le nom de votre base de données
            String user = "root"; // Remplacez "votre_utilisateur" par le nom d'utilisateur de MySQL
            String password = ""; // Remplacez "votre_mot_de_passe" par le mot de passe de MySQL
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            // Vérifier si la table "employees" existe déjà
            String checkTableSQL = "SELECT 1 FROM employees LIMIT 1";
            statement.executeQuery(checkTableSQL);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

