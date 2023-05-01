package Factory;

public enum Departments {
    RND("Research & Development");

    private final String values;

    Departments(String value) {
        this.values = value;
    }

    public String getValues() {
        return values;
    }
}
