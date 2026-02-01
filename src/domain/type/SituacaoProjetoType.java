package domain.type;

public enum SituacaoProjetoType {
    NAO_INICIADO("Não iniciado"),
    INICIADO("Iniciado"),
    PAUSADO("Pausado"),
    CONCLUIDO("Concluido");

    private final String descricao;

    SituacaoProjetoType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public static SituacaoProjetoType getType(String typeName) {
        return values().stream()
                        .filter(e -> e.name().equals(typeName))
                        .findFirst()
                        .orElse(null);
    }
}
