package Backend;

public class Feedback {
    boolean completed;
    String dateSubmitted;
    int userTypeSubmitted;
    int threatLevel; 
    String feedbackReport;

    public Feedback() {
        completed = false;
        dateSubmitted = "";
        userTypeSubmitted = 1;
        threatLevel = 0;
        feedbackReport = "";
    }
    public Feedback(boolean completed, String dateSubmitted, int userTypeSubmitted, int threatLevel, String feedbackReport) {
        this.completed = completed;
        this.dateSubmitted = dateSubmitted;
        this.userTypeSubmitted = userTypeSubmitted;
        this.threatLevel = threatLevel;
        this.feedbackReport = feedbackReport;
    }
    public String typeToString(){
        if (userTypeSubmitted == 1){
            return "Applicant";
        }
        else if (userTypeSubmitted == 2){
            return "Admin";
        }
        else if (userTypeSubmitted == 3){
            return "Reviewer";
        }
        else if (userTypeSubmitted == 4){
            return "Sponsor";
        }
        else if (userTypeSubmitted == 5){
            return "Stewer";
        }
        else if (userTypeSubmitted == 6){
            return "Support";
        }
        return "Applicant";
    }

    @Override
    public String toString() {
        return  "Date Submitted: '" + dateSubmitted + '\'' +
                ", Completed: " + completed +
                ", User: '" + typeToString() + '\'' +
                ", Threat Level: " + threatLevel +
                ", Report: '" + feedbackReport + '\'';
    }

}
