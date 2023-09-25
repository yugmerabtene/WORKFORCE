package fr.workforce.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.workforce.models.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private Connection connection;

    public EmployeeRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createEmployee(Employee employee) {
        PreparedStatement preparedStatement = null;
        try {
            String insertSQL = "INSERT INTO employees (matricule, firstName, lastName, dateOfBirth, hireYear, otherInfo) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getMatricule());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getDateOfBirth());
            preparedStatement.setInt(5, employee.getHireYear());
            preparedStatement.setString(6, employee.getOtherInfo());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating employee failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    employee.setId(id);
                } else {
                    throw new SQLException("Creating employee failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String matricule = resultSet.getString("matricule");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                int hireYear = resultSet.getInt("hireYear");
                String otherInfo = resultSet.getString("otherInfo");

                Employee employee = new Employee(id, matricule, firstName, lastName, dateOfBirth, hireYear, otherInfo);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String selectSQL = "SELECT * FROM employees WHERE id=?";
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String matricule = resultSet.getString("matricule");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                int hireYear = resultSet.getInt("hireYear");
                String otherInfo = resultSet.getString("otherInfo");

                return new Employee(id, matricule, firstName, lastName, dateOfBirth, hireYear, otherInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee updatedEmployee) {
        PreparedStatement preparedStatement = null;
        try {
            String updateSQL = "UPDATE employees SET matricule=?, firstName=?, lastName=?, dateOfBirth=?, hireYear=?, otherInfo=? WHERE id=?";
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, updatedEmployee.getMatricule());
            preparedStatement.setString(2, updatedEmployee.getFirstName());
            preparedStatement.setString(3, updatedEmployee.getLastName());
            preparedStatement.setString(4, updatedEmployee.getDateOfBirth());
            preparedStatement.setInt(5, updatedEmployee.getHireYear());
            preparedStatement.setString(6, updatedEmployee.getOtherInfo());
            preparedStatement.setInt(7, updatedEmployee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteEmployee(int id) {
        PreparedStatement preparedStatement = null;
        try {
            String deleteSQL = "DELETE FROM employees WHERE id=?";
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
