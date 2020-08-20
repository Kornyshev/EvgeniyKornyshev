package hw5.tests.steps;

import hw5.context.Context;
import hw5.context.User;
import hw5.pages.MainPage;
import hw5.services.UserCreator;
import io.cucumber.java.en.Given;

public class ModelSteps {

    MainPage mainPage =
            new MainPage(Context.getInstance().getDriver());

    @Given("I open JDI GitHub site on Main page")
    public void i_open_JDI_GitHub_site_on_Main_page() {
        mainPage.openPage();
    }

    @Given("I login as user {string}")
    public void i_login_as_user(String user) {
        User testUser = UserCreator.createFromPropertiesFile(user);
        mainPage.loginAs(testUser);
    }
}