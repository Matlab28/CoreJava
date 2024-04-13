package Uno;

public enum Cards {
    RED("Red"),
    GREEN("Green"),
    YELLOW("Yellow"),
    BLUE("Blue"),
    BLOCK("Block"),
    FOUR_PLUS("4+"),
    TWO_PLUS("2+"),
    REVERSED("Reversed");

    private String value;

    Cards(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
