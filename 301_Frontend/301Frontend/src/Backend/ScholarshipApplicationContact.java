package Backend;

public class ScholarshipApplicationContact {
    scholarship scholarship;
    StudentApplication stuapp;
    String name;
    String phoneNumber;
    String email;

    // Default Constructor
    public ScholarshipApplicationContact() {
        // Initialize default values if needed
    }

    // Normal Constructor
    public ScholarshipApplicationContact(scholarship scholarship, StudentApplication stuapp, String name,
            String phoneNumber, String email) {
        this.scholarship = scholarship;
        this.stuapp = stuapp;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public scholarship getScholarship() {
        return scholarship;
    }

    public StudentApplication getStuapp() {
        return stuapp;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setScholarship(scholarship scholarship) {
        this.scholarship = scholarship;
    }

    public void setStuapp(StudentApplication stuapp) {
        this.stuapp = stuapp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}