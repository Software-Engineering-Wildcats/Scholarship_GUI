package Backend;

public class Feedback {
    boolean completed;
    String reportTitle;
    String dateSubmitted;
    int userTypeSubmitted;
    int threatLevel;
    String feedbackReport;
    String notes;

    public Feedback() {
        completed = false;
        reportTitle = "";
        dateSubmitted = "";
        userTypeSubmitted = 1;
        threatLevel = 0;
        feedbackReport = "";
        notes = "";
    }

    public Feedback(boolean completed, String reportTitle, String dateSubmitted, int userTypeSubmitted, int threatLevel,
            String feedbackReport, String notes) {
        this.completed = completed;
        this.reportTitle = reportTitle;
        this.dateSubmitted = dateSubmitted;
        this.userTypeSubmitted = userTypeSubmitted;
        this.threatLevel = threatLevel;
        this.feedbackReport = feedbackReport;
        this.notes = notes;
    }

    // Getter methods
    public boolean isCompleted() {
        return completed;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public int getUserTypeSubmitted() {
        return userTypeSubmitted;
    }

    public int getThreatLevel() {
        return threatLevel;
    }

    public String getFeedbackReport() {
        return feedbackReport;
    }

    public String getNotes() {
        return notes;
    }

    // Setter methods
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public void setUserTypeSubmitted(int userTypeSubmitted) {
        this.userTypeSubmitted = userTypeSubmitted;
    }

    public void setThreatLevel(int threatLevel) {
        this.threatLevel = threatLevel;
    }

    public void setFeedbackReport(String feedbackReport) {
        this.feedbackReport = feedbackReport;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String typeToString() {
        if (userTypeSubmitted == 1) {
            return "Applicant";
        } else if (userTypeSubmitted == 2) {
            return "Admin";
        } else if (userTypeSubmitted == 3) {
            return "Reviewer";
        } else if (userTypeSubmitted == 4) {
            return "Sponsor";
        } else if (userTypeSubmitted == 5) {
            return "Steward";
        } else if (userTypeSubmitted == 6) {
            return "Support";
        }
        return "Applicant";
    }

    public static String typeToString(int n) {
        if (n == 1) {
            return "Applicant";
        } else if (n == 2) {
            return "Admin";
        } else if (n == 3) {
            return "Reviewer";
        } else if (n == 4) {
            return "Sponsor";
        } else if (n == 5) {
            return "Steward";
        } else if (n == 6) {
            return "Support";
        }
        return "Applicant";
    }

    @Override
    public String toString() {
        return "Report Title: '" + reportTitle + '\'' +
                "\n\nDate Submitted: '" + dateSubmitted + '\'' +
                "\nCompleted: " + completed +
                "\nUser: '" + typeToString() + '\'' +
                "\nThreat Level: " + threatLevel +
                "\nReport: '" + feedbackReport + '\'';
    }

}
