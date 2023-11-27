package Backend;

public class AppData {
    private static AppData instance;
    private User currentUser;

    private AppData() {
        currentUser = null;
    }

    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    public User getSharedVariable() {
        return currentUser;
    }

    public void setSharedVariable(User currentUser) {
        this.currentUser = currentUser;
    }
}
