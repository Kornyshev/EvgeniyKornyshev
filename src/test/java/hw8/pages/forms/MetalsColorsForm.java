package hw8.pages.forms;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw8.data.beans.DataBean;
import hw8.pages.custom.MultiDropdown;


public class MetalsColorsForm extends Form<DataBean> {

    @Css("#summary-block .info-panel-section label")
    public JList<Label> summary;

    @Css("#elements-checklist label")
    public JList<Label> elements;

    @JDropdown(
            root = "div[ui='dropdown']",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colors;

    @JDropdown(
            root = "div[ui='combobox']",
            value = "input",
            list = "li",
            expand = ".caret")
    public Dropdown metals;

    @JDropdown(
            root = "div[ui='droplist']",
            value = "label",
            list = "li",
            expand = ".caret")
    public MultiDropdown vegetables;

    @Css("button#submit-button")
    public Button submit;

    @Override
    public void fill(DataBean entity) {
        for (Label radio : summary) {
            if (radio.getText().equals(String.valueOf(entity.getSummary()[0]))
                    || radio.getText().equals(String.valueOf(entity.getSummary()[1]))) {
                radio.click();
            }
        }
        for (Label element : elements) {
            if (element.getText().equals(entity.getElements()[0])
                    || element.getText().equals(entity.getElements()[1])) {
                element.click();
            }
        }
        colors.select(entity.getColor());
        metals.select(entity.getMetals());
        vegetables.select(vegetables.selected());
        for (String vegetable : entity.getVegetables()) {
            vegetables.select(vegetable);
        }
    }
}