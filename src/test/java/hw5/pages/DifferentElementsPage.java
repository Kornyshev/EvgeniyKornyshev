package hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.colors select")
    private WebElement colorSelect;

    @FindBy(css = "div.checkbox-row label")
    private List<WebElement> checkboxes;

    public void clickOnCheckboxOrRadio(String elementText) {
        for (WebElement element : checkboxes) {
            if (element.getText().equalsIgnoreCase(elementText)) {
                element
                        .findElement(By.tagName("input"))
                        .click();
            }
        }
    }

    public void selectColor(String color) {
        new Select(colorSelect).selectByVisibleText(color);
    }

    public String getActualUsername() {
        return headerMenu.getUserName();
    }
}