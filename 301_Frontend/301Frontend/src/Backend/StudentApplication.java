package Backend;

public class StudentApplication {
    private String name;
    private long netID;
    private String major;
    private String minor;
    private String essay;

    // default constructor
    public StudentApplication() {
        this.name = "noname";
        this.netID = 1234567890123456L;
        this.major = "Undecided";
        this.minor = "None";
        this.essay = "Default Essay";
    }

    // constructor
    public StudentApplication(String name, long netID, String major, String minor, String essay) {
        this.name = name;
        this.netID = netID;
        this.major = major;
        this.minor = minor;
        this.essay = essay;
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNetID() {
        return netID;
    }

    public void setNetID(long netID) {
        this.netID = netID;
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

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    public String toString() {
        return "Name: " + name + "\n" +
                "NetID: " + netID + "\n" +
                "Major: " + major + "\n" +
                "Minor: " + minor + "\n" +
                "Essay: " + essay;
    }
}