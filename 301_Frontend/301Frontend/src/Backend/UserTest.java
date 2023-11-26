package Backend;
import java.util.ArrayList;

public class UserTest {
    private ArrayList<User> users = new ArrayList<>();
    public ArrayList<User> createUsers(){

        // Manually create users
        User user1 = new User("user1@example.com", "password1", "User One", 1);
        User user2 = new User("user2@example.com", "password2", "User Two", 2);
        User user3 = new User("user3@example.com", "password3", "User Three", 3);
        User user4 = new User("user4@example.com", "password4", "User Four", 4);
        User user5 = new User("user5@example.com", "password5", "User Five", 5);
        User user6 = new User("user6@example.com", "password6", "User Six", 6);

        // Add users to the list
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        
        return users;
    }
    public void addUser(String email, String password, String name, int id) {
        // Create a new user and add it to the list
        User newUser = new User(email, password, name, id);
        users.add(newUser);
    }
    public ArrayList<User> getUsers(){
        //createUsers();
        return users;
    }
}
