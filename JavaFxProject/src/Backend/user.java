package Backend;

//This is a parent class for all users
//For this file we will use inheritance 
//The specific users will be a child 
public class user {
    private String name;
    private String emailAddress;
    private String securityQuestion; // CSV of the 3 security questions that can be split later through .split()
                                     // method
    private String securityQuestionAnswers; // CSV of the 3 security questions that can be split later through .split()
                                            // method
    private String userPermission; // This is the permission level of the user. This will be used to determine what
                                   // the user can do in the system

    public user() { // default constructor
        this.name = "No Name";
        this.emailAddress = "None";
        this.securityQuestion = "None";
        this.securityQuestionAnswers = "None";
        this.userPermission = "None";
    }

    ////// Overload constructors for the user class //////
    public user(String name) {
        this.name = name;
        this.emailAddress = "None";
        this.securityQuestion = "None";
        this.securityQuestionAnswers = "None";
        this.userPermission = "None";
    }

    public user(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.securityQuestion = "None";
        this.securityQuestionAnswers = "None";
        this.userPermission = "None";
    }

    public user(String name, String emailAddress, String securityQuestion) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.securityQuestion = securityQuestion;
        this.securityQuestionAnswers = "None";
        this.userPermission = "None";
    }

    public user(String name, String emailAddress, String securityQuestion, String securityQuestionAnswers) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.securityQuestion = securityQuestion;
        this.securityQuestionAnswers = securityQuestionAnswers;
        this.userPermission = "None";
    }

    public user(String name, String emailAddress, String securityQuestion, String securityQuestionAnswers,
            String userPermission) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.securityQuestion = securityQuestion;
        this.securityQuestionAnswers = securityQuestionAnswers;
        this.userPermission = userPermission;
    }
    ////// End of overloaded constructors for the user class //////

    ////// Getters and Setters for the user class //////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityQuestionAnswers() {
        return securityQuestionAnswers;
    }

    public void setSecurityQuestionAnswers(String securityQuestionAnswers) {
        this.securityQuestionAnswers = securityQuestionAnswers;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }
    ////// End of getters and setters for the user class //////

}
