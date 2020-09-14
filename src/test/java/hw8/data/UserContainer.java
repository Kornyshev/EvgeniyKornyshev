package hw8.data;

import hw8.data.entities.User;

import java.util.ResourceBundle;

public class UserContainer {
    public static final User ROMAN = getUserFromResources();

    private static User getUserFromResources() {
        ResourceBundle bundle = ResourceBundle.getBundle("User");
        return new User(
                bundle.getString("user.name.RomanIovlev"),
                bundle.getString("user.password.RomanIovlev"),
                bundle.getString("user.fullname.RomanIovlev"));
    }
}