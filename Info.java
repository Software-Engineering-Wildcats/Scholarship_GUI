public class Info {
    private int studentID;
    private String studentName;
    private String status;
    private int funds;

    public Info(int studentID, String studentName, String status, int funds) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.status = status;
        this.funds = funds;
    }

    // Getters
    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStatus() {
        return status;
    }

    public int getFunds() {
        return funds;
    }

    // Setters
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }
}

