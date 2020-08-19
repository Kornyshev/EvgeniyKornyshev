package hw5.steps;

import io.cucumber.java.en.When;

public class ActionSteps {

    @When("I check {string} checkbox in Checkbox block on the Different Elements page")
    public void i_check_checkbox_in_Checkbox_block_on_the_Different_Elements_page(
            String checkboxText) {
        throw new io.cucumber.java.PendingException();
    }

    @When("I click on {string} radio button on the Different Elements page")
    public void i_click_on_radio_button_on_the_Different_Elements_page(String radioText) {
        throw new io.cucumber.java.PendingException();
    }

    @When("I select {string} color in dropdown on the Different Elements page")
    public void i_select_color_in_dropdown_on_the_Different_Elements_page(String color) {
        throw new io.cucumber.java.PendingException();
    }

    @When("I select {string} checkbox for {string} on User Table page")
    public void i_select_checkbox_for_on_User_Table_page(String checkboxText, String user) {
        throw new io.cucumber.java.PendingException();
    }

    @When("I click on {string} button in Header on the Main page")
    public void i_click_on_button_in_Header_on_the_Main_page(String linkText) {
        throw new io.cucumber.java.PendingException();
    }

    @When("I click on {string} button in Service dropdown on the Main page")
    public void i_click_on_button_in_Service_dropdown_on_the_Main_page(String itemInDropdown) {
        throw new io.cucumber.java.PendingException();
    }
}