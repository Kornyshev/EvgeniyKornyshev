package hw5.services;

import hw5.context.User;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class UserCreator {

    public static User createFromPropertiesFile(String user) {
        ResourceBundle bundle = ResourceBundle.getBundle("User");
        user = user.replaceAll(" ", "");
        try {
            String username = bundle.getString("user.name." + user);
            String password = bundle.getString("user.password." + user);
            return new User(username, password);
        } catch (MissingResourceException e) {
            throw new NoSuchTestUserException("I can't find such User in property file", e);
        }
    }
}
