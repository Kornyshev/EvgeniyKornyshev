package hw5.tests.steps;

import hw5.context.Context;
import hw5.pages.DifferentElementsPage;
import hw5.pages.LoggedInMainPage;
import hw5.pages.UserTablePage;
import io.cucumber.java.en.When;

public class ActionSteps {

    DifferentElementsPage differentElementsPage =
            new DifferentElementsPage(Context.getInstance().getDriver());
    UserTablePage userTablePage =
            new UserTablePage(Context.getInstance().getDriver());
    LoggedInMainPage loggedInMainPage =
            new LoggedInMainPage(Context.getInstance().getDriver());


    @When("I click {string} checkbox in Checkbox block on the Different Elements page")
    public void i_click_checkbox_in_Checkbox_block_on_the_Different_Elements_page(
            String checkboxText) {
        differentElementsPage.clickOnCheckboxOrRadio(checkboxText);
    }

    @When("I click on {string} radio button on the Different Elements page")
    public void i_click_on_radio_button_on_the_Different_Elements_page(String radioText) {
        differentElementsPage.clickOnCheckboxOrRadio(radioText);
    }

    @When("I select {string} color in dropdown on the Different Elements page")
    public void i_select_color_in_dropdown_on_the_Different_Elements_page(String color) {
        differentElementsPage.selectColor(color);
    }

    @When("I select 'vip' checkbox for {string} on User Table page")
    public void i_select_checkbox_for_on_User_Table_page(String user) {
        userTablePage.clickOnVipCheckboxOnUserCard(user);
    }

    @When("I click on {string} button in Header on the Main page")
    public void i_click_on_button_in_Header_on_the_Main_page(String linkText) {
        loggedInMainPage.clickOnHeaderMenuLink(linkText);
    }

    @When("I click on {string} button in Service dropdown on the Main page")
    public void i_click_on_button_in_Service_dropdown_on_the_Main_page(String itemInDropdown) {
        loggedInMainPage.clickOnHeaderMenuLink(itemInDropdown);
    }
}