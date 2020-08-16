package hw3.pages;

import hw3.pages.components.DiffElemPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    public final DiffElemPageComponents components;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        components = new DiffElemPageComponents(driver);
    }

    public List<WebElement> getAllElements() {
        return components.allElementsOnPageForAssertion();
    }

    public boolean logAreaIsDisplayed() {
        return components.logAreaIsDisplayed();
    }
}