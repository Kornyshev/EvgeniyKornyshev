package hw8.tests;

import hw8.pages.JdiSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static hw8.pages.JdiSite.mainPage;

interface CommonConditions {

    @BeforeSuite(alwaysRun = true)
    static void settingUp() {
        initSite(JdiSite.class);
        mainPage.open();
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}