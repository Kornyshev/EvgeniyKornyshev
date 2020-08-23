package hw5.pages.composites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LogsList {

    public LogsList(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "ul.panel-body-list.logs li")
    private List<WebElement> logs;

    public List<String> getActualLogsMessages() {
        return logs
                .stream()
                .map(el -> {
                    int space = el.getText().indexOf(" ");
                    return el.getText().substring(space + 1).trim(); })
                .collect(Collectors.toList());
    }
}