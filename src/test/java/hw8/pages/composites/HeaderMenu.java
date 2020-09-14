package hw8.pages.composites;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;

public class HeaderMenu extends JList<UIElement> {

    public void clickOnParticularMenuItem(String link) {
        for (UIElement item : this) {
            if (item.getText().equalsIgnoreCase(link)) {
                item.click();
                break;
            }
        }
    }
}