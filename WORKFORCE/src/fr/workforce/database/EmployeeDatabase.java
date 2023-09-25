// �tape 1: Cr�ation de la base de donn�es
package fr.workforce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDatabase {

    // M�thode pour v�rifier l'existence de la base de donn�es
    public static void checkDatabase() {
        Connection connection = null;
        Statement statement = null;

        try {
            // Charger le pilote JDBC MySQL (assurez-vous d'ajouter la biblioth�que MySQL JDBC � votre projet)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // �tablir une connexion � la base de donn�es MySQL
            String url = "jdbc:mysql://localhost:3306/workforce"; // Remplacez "votre_base_de_donnees" par le nom de votre base de donn�es
            String user = "root"; // Remplacez "votre_utilisateur" par le nom d'utilisateur de MySQL
            String password = ""; // Remplacez "votre_mot_de_passe" par le mot de passe de MySQL
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            // V�rifier si la table "employees" existe d�j�
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

