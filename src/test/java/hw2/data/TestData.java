package hw2.data;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "TestUserData")
    public Object[][] getTestUserData() {
        return new Object[][]{
                {"Roman", "Jdi1234"}
        };
    }

    @DataProvider(name = "ExpectedTextBelowImages")
    public Object[][] getExpectedTextBelowImages() {
        return new Object[][]{
                {   "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                    "To be flexible and\n" +
                            "customizable",
                    "To be multiplatform",
                    "Already have good base\n" +
                            "(about 20 internal and\n" +
                            "some external projects),\n" +
                            "wish to get more…"}
        };
    }

    @DataProvider(name = "ExpectedTextOfMainCenterTitles")
    public Object[][] getExpectedTextOfMainCenterTitles() {
        return new Object[][]{
                {   "EPAM FRAMEWORK WISHES…",
                    "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
                            "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE " +
                            "ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM " +
                            "VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                            "LABORIS NISI UT " +
                            "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE " +
                            "DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
                            "CILLUM DOLORE EU FUGIAT NULLA PARIATUR."}
        };
    }
}