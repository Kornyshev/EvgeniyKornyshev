package hw5.tests.steps;

import hw5.context.Context;
import hw5.pages.DifferentElementsPage;
import hw5.pages.LoggedInMainPage;
import hw5.pages.UserTablePage;
import hw5.pages.composites.LogsList;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionSteps {

    DifferentElementsPage differentElementsPage =
            new DifferentElementsPage(Context.getInstance().getDriver());
    UserTablePage userTablePage =
            new UserTablePage(Context.getInstance().getDriver());
    LoggedInMainPage loggedInMainPage =
            new LoggedInMainPage(Context.getInstance().getDriver());

    @Then("user name should be equal to {string}")
    public void user_name_should_be_equal_to(String userName) {
        String actualUsername = differentElementsPage.getActualUsername();
        assertThat(actualUsername).isEqualTo(userName.toUpperCase());
    }

    @Then("{int} log row has {string} text in log section")
    public void log_row_has_text_in_log_section(Integer i, String expectedLog) {
        String actualLog = new LogsList(Context.getInstance().getDriver())
                .getActualLogsMessages()
                .get(i - 1);
        assertThat(actualLog).isEqualTo(expectedLog);
    }

    @Then("{string} page should be opened")
    public void page_should_be_opened(String pageTitle) {
        String actualTitle = userTablePage.getTitle();
        assertThat(actualTitle).isEqualTo(pageTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table page")
    public void number_Type_Dropdowns_should_be_displayed_on_Users_Table_on_User_Table_page(
            Integer count) {
        int selectsCount = userTablePage.getSelectsCount();
        assertThat(selectsCount).isEqualTo(count);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table page")
    public void usernames_should_be_displayed_on_Users_Table_on_User_Table_page(Integer count) {
        int usernamesCount = userTablePage.getUsernamesCount();
        assertThat(usernamesCount).isEqualTo(count);
    }

    @Then("{int} Description texts under images should be displayed "
            + "on Users Table on User Table page")
    public void description_texts_under_images_should_be_displayed_on_Users_Table_on_User_Table_page(
            Integer count) {
        int descriptionsCount = userTablePage.getDescriptionsCount();
        assertThat(descriptionsCount).isEqualTo(count);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table page")
    public void checkboxes_should_be_displayed_on_Users_Table_on_User_Table_page(Integer count) {
        int checkboxesCount = userTablePage.getCheckboxesCount();
        assertThat(checkboxesCount).isEqualTo(count);
    }

    @Then("User table should contain following values:")
    public void user_table_should_contain_following_values(DataTable dataTable) {
        List<List<String>> expectedTable = dataTable.asLists().subList(1, 7);
        List<List<String>> actualTable = userTablePage.getActualDataTable();
        assertThat(actualTable).isEqualTo(expectedTable);
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void droplist_should_contain_values_in_column_Type_for_user_Roman(
            String user, DataTable dataTable) {
        List<String> expectedTable = dataTable.asList().subList(1, 4);
        List<String> actualTable = userTablePage.getDropdownListForUser(user);
        assertThat(actualTable).isEqualTo(expectedTable);
    }
}