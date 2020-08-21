package hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends AbstractPage {

    @FindBy(css = "table#user-table tbody tr")
    private List<WebElement> usersCards;

    @FindBy(css = "table#user-table tbody tr select")
    private List<WebElement> allSelects;

    @FindBy(css = "table#user-table tbody tr a")
    private List<WebElement> allUsernames;

    @FindBy(css = "table#user-table tbody tr div.user-descr")
    private List<WebElement> allDescriptions;

    @FindBy(css = "table#user-table tbody tr div.user-descr input")
    private List<WebElement> allCheckboxes;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    private WebElement findConcreteUserCardOnPage(String username) {
        for (WebElement card : usersCards) {
            if (card.getText().contains("Number")
                    && card.getText().contains("Type")
                    && card.getText().contains("User")
                    && card.getText().contains("Description")) {
                continue;
            }
            if (card.findElement(By.cssSelector("a")).getText().equalsIgnoreCase(username)) {
                return card;
            }
        }
        throw new NoSuchElementException(
                "I can't find UserCard with that username - " + username);
    }

    public void clickOnVipCheckboxOnUserCard(String username) {
        findConcreteUserCardOnPage(username)
                .findElement(By.cssSelector("input[type='checkbox']"))
                .click();
    }

    public List<List<String>> getActualDataTable() {
        List<List<String>> res = new ArrayList<>();
        for (WebElement card : usersCards) {
            if (card.findElements(By.tagName("th")).size() == 4) {
                continue;
            }
            String number = card.findElement(By.tagName("td")).getText();
            String user = card.findElement(By.tagName("a")).getText();
            String description = card.findElement(By.cssSelector(
                    "div.user-descr span"))
                    .getText()
                    .replaceAll("\n", " ");
            res.add(Arrays.asList(number, user, description));
        }
        return res;
    }

    public List<String> getDropdownListForUser(String username) {
        return findConcreteUserCardOnPage(username)
                .findElements(By.cssSelector("select option"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public int getSelectsCount() {
        return allSelects.size();
    }

    public int getUsernamesCount() {
        return allUsernames.size();
    }

    public int getDescriptionsCount() {
        return allDescriptions.size();
    }

    public int getCheckboxesCount() {
        return allCheckboxes.size();
    }
}