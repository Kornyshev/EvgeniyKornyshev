package hw3.pages.components;

import hw3.data.SelectColor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DiffElemPageComponents {

    public DiffElemPageComponents(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.checkbox-row label")
    private List<WebElement> allCheckboxes;

    @FindBy(css = "ul.panel-body-list.logs")
    private WebElement logArea;

    @FindBy(css = "ul.panel-body-list.logs li")
    private List<WebElement> logs;

    @FindBy(css = "div.colors select")
    private WebElement colorSelect;

    @FindBy(xpath = "//div[3]//label[4]//input[1]")
    private WebElement selenRadio;

    @FindBy(xpath = "//div//div//div//div[2]//label[1]//input[1]")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//div//div//div//div[2]//label[3]//input[1]")
    private WebElement windCheckbox;

    @FindBy(css = "button[name='Default Button']")
    private WebElement defaultButton;

    @FindBy(css = "input[value='Button']")
    private WebElement button;

    public boolean waterIsChecked() {
        return waterCheckbox.isSelected();
    }

    public void clickWaterCheckbox() {
        waterCheckbox.click();
    }

    public boolean windIsChecked() {
        return windCheckbox.isSelected();
    }

    public void clickWindCheckbox() {
        windCheckbox.click();
    }

    public boolean selenRadioIsChecked() {
        return selenRadio.isSelected();
    }

    public void setSelenRadio() {
        selenRadio.click();
    }

    public String getFirstSelectedColor() {
        return new Select(colorSelect).getFirstSelectedOption().getText();
    }

    public void selectColor(SelectColor color) {
        new Select(colorSelect).selectByVisibleText(color.getColor());
    }

    public List<WebElement> getActualLogs() {
        return logs;
    }

    public List<WebElement> allElementsOnPageForAssertion() {
        List<WebElement> res = new ArrayList<>(allCheckboxes);
        res.add(colorSelect);
        res.add(defaultButton);
        res.add(button);
        return res;
    }

    public boolean logAreaIsDisplayed() {
        return logArea.isDisplayed();
    }
}