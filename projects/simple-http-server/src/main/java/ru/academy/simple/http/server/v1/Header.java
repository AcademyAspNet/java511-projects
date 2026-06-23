package ru.academy.simple.http.server.v1;

public class Header {

    private final String name;
    private final String value;

    public Header(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "%s: %s".formatted(name, value);
    }

    public static Header fromString(String string) {
        String[] parts = string.split(": ");

        String name = parts[0];
        String value = parts[1];

        return new Header(name, value);
    }
}
