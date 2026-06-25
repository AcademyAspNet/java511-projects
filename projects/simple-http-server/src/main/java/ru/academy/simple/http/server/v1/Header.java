package ru.academy.simple.http.server.v1;

public record Header(String name, String value) {

    public Header {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Header name cannot be null or blank");

        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Header value cannot be null or blank");
    }

    @Override
    public String toString() {
        return "%s: %s".formatted(name, value);
    }

    public static Header fromString(String string) {
        String[] parts = string.split(":", 2);

        if (parts.length != 2)
            throw new IllegalArgumentException("Failed to split input string: " + string);

        String name = parts[0];
        String value = parts[1];

        return new Header(name, value);
    }
}
