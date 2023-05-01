package Factory;

public enum Languages {
    EN("English");

    private final String values;

    Languages(String value) {
        this.values = value;
    }
    public String getValues() {
        return values;
    }
}
