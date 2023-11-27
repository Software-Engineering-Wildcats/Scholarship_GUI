package Backend;

    public class AppData {
        private static AppData instance;
        private User sharedVariable;
    
        private AppData() {
            // Private constructor to enforce singleton pattern
        }
    
        public static AppData getInstance() {
            if (instance == null) {
                instance = new AppData();
            }
            return instance;
        }
    
        public User getSharedVariable() {
            return sharedVariable;
        }
    
        public void setSharedVariable(User user) {
            this.sharedVariable = user;
        }
    }   