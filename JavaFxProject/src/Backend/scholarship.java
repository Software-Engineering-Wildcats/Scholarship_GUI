package Backend;

public class scholarship {
    private String scholarshipName;
    private int payout;
    private String deadline;
    private String customRequiredInfo;
    private String preferedMajors;

    public scholarship() { // This is the constructor
        this.scholarshipName = "No Name";
        this.payout = 0;
        this.deadline = "N/A";
        this.customRequiredInfo = "None";
        this.preferedMajors = "None";
    }

    ///// Start Overloaded constructors for the scholarship class /////
    public scholarship(String scholarshipName) {
        this.scholarshipName = scholarshipName;
        this.payout = 0;
        this.deadline = "N/A";
        this.customRequiredInfo = "None";
        this.preferedMajors = "None";
    }

    public scholarship(String scholarshipName, int payout) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = "N/A";
        this.customRequiredInfo = "None";
        this.preferedMajors = "None";
    }

    public scholarship(String scholarshipName, int payout, String deadline) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = deadline;
        this.customRequiredInfo = "None";
        this.preferedMajors = "None";
    }

    public scholarship(String scholarshipName, int payout, String deadline, String customRequiredInfo) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = deadline;
        this.customRequiredInfo = customRequiredInfo;
        this.preferedMajors = "None";
    }

    public scholarship(String scholarshipName, int payout, String deadline, String customRequiredInfo,
            String preferedMajors) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = deadline;
        this.customRequiredInfo = customRequiredInfo;
        this.preferedMajors = preferedMajors;
    }
    ///// End Overloaded constructors for the scholarship class /////

    ///////// Start mutators and accessors /////////

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public int getPayout() {
        return payout;
    }

    public void setPayout(int payout) {
        this.payout = payout;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getCustomRequiredInfo() {
        return customRequiredInfo;
    }

    public void setCustomRequiredInfo(String customRequiredInfo) {
        this.customRequiredInfo = customRequiredInfo;
    }

    public String getPreferedMajors() {
        return preferedMajors;
    }

    public void setPreferedMajors(String preferedMajors) {
        this.preferedMajors = preferedMajors;
    }
    ///////// End mutators and accessors /////////

}
