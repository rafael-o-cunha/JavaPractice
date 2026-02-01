package domain.type;

public enum TarefaType {
    MELHORIA("Melhoria"),
    DESENVOLVIMENTO("Desenvolvimento"),
    DEFEITO_INTERNO("Defeito Interno"),
    DEFEITO_EXTERNO("Defeito Externo");

    private final String descricao;

    TarefaType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TarefaType getType(String typeName) {
        return values().stream()
                        .filter(e -> e.name().equals(typeName))
                        .findFirst()
                        .orElse(null);
    }
}
