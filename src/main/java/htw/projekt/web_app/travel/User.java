package htw.projekt.web_app.travel;
import jakarta.persistence.*;

@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    private String userName;
    private String email;
    private String password;
    private boolean guestMode;

    public User() {
    }

    public User(long userID, String userName, String email, String password, boolean guestMode) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.guestMode = guestMode;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGuestMode() {
        return guestMode;
    }

    public void setGuestMode(boolean guestMode) {
        this.guestMode = guestMode;
    }
}
