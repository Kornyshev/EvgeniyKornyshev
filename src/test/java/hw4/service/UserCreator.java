package hw4.service;

import hw4.model.User;

import java.util.ResourceBundle;

public class UserCreator {

    public static User createFromPropertiesFile() {
        ResourceBundle bundle = ResourceBundle.getBundle("User");
        return new User(bundle.getString("user.name"),
                bundle.getString("user.password"));
    }
}