package hw4.data;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class TestData {
    @DataProvider(name = "ExpectedUsername")
    public Object[][] getTestUserData() {
        return new Object[][]{
                {"ROMAN IOVLEV"}
        };
    }

    @DataProvider(name = "ExpectedLinksText")
    public Object[][] getLinksText() {
        return new Object[][]{
                {Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS")}
        };
    }

    @DataProvider(name = "ExpectedTextBelowImages")
    public Object[][] getExpectedTextBelowImages() {
        return new Object[][]{
                {Arrays.asList("To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",
                        "To be flexible and\n"
                                + "customizable",
                        "To be multiplatform",
                        "Already have good base\n"
                                + "(about 20 internal and\n"
                                + "some external projects),\n"
                                + "wish to get more…")}
        };
    }

    @DataProvider(name = "ExpectedMainTitles")
    public Object[][] getExpectedMainTitles() {
        return new Object[][]{
                {"EPAM FRAMEWORK WISHES…",
                        "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING "
                                + "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE "
                                + "ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM "
                                + "VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO "
                                + "LABORIS NISI UT "
                                + "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE "
                                + "DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE "
                                + "CILLUM DOLORE EU FUGIAT NULLA PARIATUR."}
        };
    }

    @DataProvider(name = "ExpectedJdiTextAndLink")
    public Object[][] getExpectedJdiLink() {
        return new Object[][]{
                {"JDI GITHUB", "https://github.com/epam/JDI"}
        };
    }

    @DataProvider(name = "WaterWindAreChecked")
    public Object[][] getWaterWindAreChecked() {
        return new Object[][]{
                {"Water: condition changed to true",
                        "Wind: condition changed to true"}
        };
    }

    @DataProvider(name = "WaterWindAreUnchecked")
    public Object[][] getWaterWindAreUnchecked() {
        return new Object[][]{
                {"Water: condition changed to false",
                        "Wind: condition changed to false"}
        };
    }

    @DataProvider(name = "SelenRadioIsChecked")
    public Object[][] getSelenRadioIsChecked() {
        return new Object[][]{
                {"metal: value changed to Selen"}
        };
    }

    @DataProvider(name = "YellowIsChecked")
    public Object[][] getYellowIsChecked() {
        return new Object[][]{
                {"Colors: value changed to Yellow"}
        };
    }
}