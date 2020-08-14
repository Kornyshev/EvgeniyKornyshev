package hw4.data;

public enum SelectColor {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String color;

    SelectColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}