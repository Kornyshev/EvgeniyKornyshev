package hw8.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import hw8.pages.composites.HeaderMenu;
import hw8.pages.forms.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light")
public class JdiSite {

    @Url("/index.html")
    @Title("Home Page")
    public static MainPage mainPage;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;

    @Css("#user-icon")
    public static Icon userIcon;

    @Css("#login-form")
    public static LoginForm loginForm;

    @Css("div.logout")
    public static Button logoutButton;

    @Css("#user-name")
    public static UIElement userName;

    @Css(".uui-navigation.nav.navbar-nav.m-l8 li")
    public static HeaderMenu headerMenu;
}