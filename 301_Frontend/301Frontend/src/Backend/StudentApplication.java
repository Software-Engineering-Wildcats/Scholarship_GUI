package Backend;

public class StudentApplication {
    private String name;
    private String netID;
    private String studentID;
    private String major;
    private String minor;
    private String academicAche;
    private boolean financialAid;
    private String essay;

    // default constructor
    public StudentApplication() {
        this.name = "noname";
        this.netID = "lastnamefirstinitial";
        this.studentID = "123456789";
        this.major = "Undecided";
        this.minor = "None";
        this.academicAche = "None";
        this.financialAid = false;
        this.essay = "Default Essay";
    }

    // constructor
    public StudentApplication(String name, String netID, String studentID, String major, String minor, String academicAche, boolean financialAid, String essay) {
        this.name = name;
        this.netID = netID;
        this.studentID = studentID;
        this.major = major;
        this.minor = minor;
        this.academicAche = academicAche;
        this.financialAid = financialAid;
        this.essay = essay;
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetID() {
        return netID;
    }

    public void setNetID(String netID) {
        this.netID = netID;
    }

    public String getstudentID() {
        return studentID;
    }

    public void setstudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getacademicAche() {
        return academicAche;
    }

    public void setacademicAche(String academicAche) {
        this.academicAche = academicAche;
    }

    public boolean getfinancialAid() {
        return financialAid;
    }

    public void setfinancialAid(boolean financialAid) {
        this.financialAid = financialAid;
    }

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    public String toString() {
        return "Name: " + name + "\n" +
                "NetID: " + netID + "\n" +
                "StudentID: " + studentID + "\n" +
                "Major: " + major + "\n" +
                "Minor: " + minor + "\n" +
                "Academic Achievement: " + academicAche + "\n" +
                "Financial Aid: " + financialAid + "\n" +
                "Essay: " + essay;
    }
}