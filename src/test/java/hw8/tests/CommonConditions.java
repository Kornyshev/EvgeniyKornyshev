package hw8.tests;

import hw8.pages.JdiSite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static hw8.pages.JdiSite.mainPage;

interface CommonConditions {

    @BeforeSuite(alwaysRun = true)
    static void settingUp() {
        initSite(JdiSite.class);
    }

    @BeforeClass
    static void beforeClass() {
        mainPage.open();
    }

    @AfterClass
    static void afterClass() {
        if (!mainPage.isOpened()) {
            //mainPage.open();
        }
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        //killAllSeleniumDrivers();
    }
}