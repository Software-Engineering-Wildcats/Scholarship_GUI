package Backend;

public class FinalScholarship {
    String name;
    String amount;
    String description;
    String requirements;
    String comments;

    // Default Constructor
    public FinalScholarship() {
        name = "Name";
        amount = "0";
        description = "Description";
        requirements = "None";
        comments = "None";
    }

    // Normal Constructor
    public FinalScholarship(String name, String amount, String description, String requirements, String comments) {
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.requirements = requirements;
        this.comments = comments;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getComments() {
        return comments;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // toString method
    @Override
    public String toString() {
        return "Name: '" + name + '\'' +
                "\nAmount='" + amount + '\'' +
                "\nDescription='" + description + '\'' +
                "\nRequirements='" + requirements + '\'' +
                "\nComments='" + comments + '\'';
    }
}
