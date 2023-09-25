// Étape 2: Création du modèle Employee
package fr.workforce.models;

public class Employee {
    private int id;
    private String matricule;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int hireYear;
    private String otherInfo;

    // Constructeur avec tous les champs
    public Employee(int id, String matricule, String firstName, String lastName, String dateOfBirth, int hireYear, String otherInfo) {
        this.id = id;
        this.matricule = matricule;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.hireYear = hireYear;
        this.otherInfo = otherInfo;
    }

    // Getters et setters pour tous les champs (à ajouter)

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", hireYear=" + hireYear +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}

