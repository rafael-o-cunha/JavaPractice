package domain.type;

public enum DbType {
    IN_MEMORY,
    FILE,
    SQLITE;

    public static DbType getType(String typeName) {
        return values().stream()
                        .filter(e -> e.name().equals(typeName))
                        .findFirst()
                        .orElse(null);
    }
}
