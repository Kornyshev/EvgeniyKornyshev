package hw2.pages;

import org.openqa.selenium.WebDriver;

public class LoggedInMainPage extends AbstractPage {

    public LoggedInMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoggedInMainPage openPage() {
        throw new UnsupportedOperationException
                ("We can't open this page directly");
    }
}