package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class AssertionSteps {

    @Then("user name should be equal to {string}")
    public void user_name_should_be_equal_to(String userName) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("Log area should contains logs about {string} checkbox checking")
    public void log_area_should_contains_logs_about_checkbox_checking(String checkboxText) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("Log area should contains logs about {string} radio selecting")
    public void log_area_should_contains_logs_about_radio_selecting(String radioText) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("Log area should contains logs about {string} color selecting")
    public void log_area_should_contains_logs_about_color_selecting(String colorSelect) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("{int} log row has {string} text in log section")
    public void log_row_has_text_in_log_section(Integer i, String expectedLog) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("{string} page should be opened")
    public void page_should_be_opened(String pageTitle) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table page")
    public void number_Type_Dropdowns_should_be_displayed_on_Users_Table_on_User_Table_page(
            Integer count) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table page")
    public void usernames_should_be_displayed_on_Users_Table_on_User_Table_page(Integer count) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("{int} Description texts under images should be displayed "
            + "on Users Table on User Table page")
    public void description_texts_under_images_should_be_displayed_on_Users_Table_on_User_Table_page(
            Integer count) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table page")
    public void checkboxes_should_be_displayed_on_Users_Table_on_User_Table_page(Integer count) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("User table should contain following values:")
    public void user_table_should_contain_following_values(DataTable dataTable) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplist_should_contain_values_in_column_Type_for_user_Roman(DataTable dataTable) {
        throw new io.cucumber.java.PendingException();
    }
}