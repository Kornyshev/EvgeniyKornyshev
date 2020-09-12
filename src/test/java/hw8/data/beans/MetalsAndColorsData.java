package hw8.data.beans;

import com.epam.jdi.tools.DataClass;

import java.util.Arrays;
import java.util.List;

import static hw8.data.ResultsStringConstants.*;

public class MetalsAndColorsData extends DataClass<MetalsAndColorsData> {

    int[] summary;
    String[] elements;
    String color;
    String metals;
    String[] vegetables;

    public List<String> expectedResultList() {
        return Arrays.asList(
                SUMMARY + Arrays.stream(summary).sum(),
                ELEMENTS + getElementsInOneString(),
                COLOR + getColor(),
                METAL + getMetals(),
                VEGETABLES + getVegetablesInOneString());
    }

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    public String getElementsInOneString() {
        return String.join(", ", elements);
    }

    public String getVegetablesInOneString() {
        return String.join(", ", vegetables);
    }
}