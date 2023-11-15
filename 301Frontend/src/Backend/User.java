package Backend;

public class User {
    private String email;
    private String password;
    private String name;
    private int typeUser;

    public User(String email, String password, String name, int typeUser) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.typeUser = typeUser;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getUserType(){
        return typeUser;
    }

    public void setUserType(String userType){
        if (userType == "Applicant"){
            typeUser = 1;
        }
        else if (userType == "Admin"){
            typeUser = 2;
        }
        else if (userType == "Reviewer"){
            typeUser = 3;
        }
        else if (userType == "Sponsor"){
            typeUser = 4;
        }
        else if (userType == "Stewer"){
            typeUser = 5;
        }
        else if (userType == "Support"){
            typeUser = 6;
        }
        else{
            typeUser = 1;
        }
    }
}
